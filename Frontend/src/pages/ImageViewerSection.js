// import React from 'react';
// import './ImageViewerSection.css';

// export default function ImageViewerSection(props) {
//   return (
//     <div className="image-viewer-section">
//       <div className="image-grid">
//         {props.images.map(image => (
//           <div className="image-card" key={image.id} onClick={() => props.onSelectImage(image)}>
//             <img src={`data:image/jpeg;base64,${image.data}`} className="card-img-top" alt={image.fileName} />
//             <div className="image-card-body">
//               <p className="card-text">{image.fileName}</p>
//             </div>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// }
import React, { useState, useRef, useEffect } from 'react';
import { fabric } from 'fabric';
import './ImageViewer.css';

export default function ImageViewer(props) {
  const [canvas, setCanvas] = useState(null);
  const [zoomLevel, setZoomLevel] = useState(1);
  const [colorIntensity, setColorIntensity] = useState(0);
  const canvasRef = useRef(null);

  useEffect(() => {
    const canvasObj = new fabric.Canvas(canvasRef.current);
    canvasObj.setWidth(600);
    canvasObj.setHeight(600);
    setCanvas(canvasObj);

    return () => {
      canvasObj.dispose();
    };
  }, []);

  useEffect(() => {
    if (canvas) {
      canvas.clear();
      canvas.setBackgroundColor('#f1f1f1', canvas.renderAll.bind(canvas));
      props.images.forEach((image, index) => {
        fabric.Image.fromURL(`data:image/jpeg;base64,${image.data}`, (img) => {
          canvas.add(img);
          img.set({ left: (index % 2) * 300, top: Math.floor(index / 2) * 300 }).scale(0.5);
        }, { crossOrigin: 'anonymous' });
      });
      canvas.renderAll();
    }
  }, [props.images, canvas]);

  const handleZoomIn = () => {
    if (canvas) {
      setZoomLevel(Math.min(2, zoomLevel + 0.1));
      canvas.setZoom(zoomLevel + 0.1);
    }
  };

  const handleZoomOut = () => {
    if (canvas) {
      setZoomLevel(Math.max(0.5, zoomLevel - 0.1));
      canvas.setZoom(zoomLevel - 0.1);
    }
  };

  const handleColorIntensityChange = (e) => {
    if (canvas) {
      setColorIntensity(e.target.value);
      canvas.set('backgroundColor', `rgba(255,255,255,${e.target.value})`);
      canvas.renderAll();
    }
  };

  const handleDeselectImage = (id) => {
    props.onDeselectImage(id);
  };

  return (
    <div className="image-viewer">
      <div className="canvas-container">
        <canvas ref={canvasRef} />
      </div>
      <div className="controls">
        <div className="zoom-controls">
          <button className="btn btn-secondary" onClick={handleZoomIn}>+</button>
          <button className="btn btn-secondary" onClick={handleZoomOut}>-</button>
        </div>
        <div className="color-controls">
          <label htmlFor="colorIntensity">Background Color Intensity:</label>
          <input type="range" min="0" max="1" step="0.1" value={colorIntensity} id="colorIntensity" onChange={handleColorIntensityChange} />
        </div>
        {props.images.map((image) => (
          <div key={image.id} className="selected-image">
            <img src={`data:image/jpeg;base64,${image.data}`} alt="" />
            <button className="btn btn-danger" onClick={() => handleDeselectImage(image.id)}>X</button>
          </div>
        ))}
      </div>
    </div>
  );
}
