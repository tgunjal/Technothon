import React, { useRef, useState, useEffect } from 'react';
import { Slider } from '@material-ui/core';
import ZoomInIcon from '@material-ui/icons/ZoomIn';
import ZoomOutIcon from '@material-ui/icons/ZoomOut';
import './ImageViewer.css';

const ImageViewer = ({ images, onDeselectImage }) => {
  const [currentImage, setCurrentImage] = useState(images.length > 0 ? images[0] : null);
  const [zoomLevel, setZoomLevel] = useState(1);
  const [intensityLevel, setIntensityLevel] = useState(100);
  const imageRef = useRef(null);

  useEffect(() => {
    setCurrentImage(images.length > 0 ? images[0] : null);
    setZoomLevel(1);
    setIntensityLevel(100);
  }, [images]);

  useEffect(() => {
    setZoomLevel(1);
    setIntensityLevel(100);
  }, [currentImage]);

  const handleImageClick = () => {
    onDeselectImage(currentImage.id);
  };

  const handleZoomIn = () => {
    setZoomLevel(zoomLevel => zoomLevel + 0.1);
  };

  const handleZoomOut = () => {
    setZoomLevel(zoomLevel => zoomLevel - 0.1);
  };

  const handleIntensityChange = (event, value) => {
    setIntensityLevel(value);
  };

  const getImageStyle = () => {
    return {
      transform: `scale(${zoomLevel})`,
      filter: `brightness(${intensityLevel}%)`,
    };
  };

  return (
    <div className="image-viewer">
      {currentImage && (
        <div className="image-container">
          <img
            ref={imageRef}
            src={`data:image/jpeg;base64,${currentImage.data}`}
            alt={currentImage.filename}
            style={getImageStyle()}
            onClick={handleImageClick}
          />
          <div className="zoom-controls">
            <button className="zoom-button" onClick={handleZoomIn}><ZoomInIcon /></button>
            <button className="zoom-button" onClick={handleZoomOut}><ZoomOutIcon /></button>
            <div className="slider-container">
              <Slider
                value={intensityLevel}
                onChange={handleIntensityChange}
                min={0}
                max={200}
                step={1}
                aria-labelledby="intensity-slider"
              />
              <div className="slider-labels">
                <div className="slider-label">Low</div>
                <div className="slider-label">High</div>
              </div>
            </div>
          </div>
        </div>
      )}
      {!currentImage && (
        <div className="no-image-message">No image selected.</div>
      )}
    </div>
  );
};

export default ImageViewer;
