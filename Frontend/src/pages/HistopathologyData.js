import React, { useState, useEffect, useRef } from 'react';
import ImageUploader from './ImageUploader';
import ImageViewer from './ImageViewer';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './HistopathologyData.css';
import ImageGallery from 'react-image-gallery';
import 'react-image-gallery/styles/css/image-gallery.css';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';

export default function HistopathologyData(props) {
  const [images, setImages] = useState([]);
  const [selectedImages, setSelectedImages] = useState([]);
  const [sidebarImages, setSidebarImages] = useState([]);
  const pdfRef = useRef();

  useEffect(() => {
    fetch(`http://localhost:8080/patient/getPathologyImages/${props.patientId}`)
      .then(response => response.json())
      .then(data => {
        setImages(data);
        setSidebarImages(data);
      })
      .catch(error => console.error(error));
  }, [props.patientId]);

  const handleSelectImages = (selected) => {
    if (selectedImages.length < 4) {
      setSelectedImages([...selectedImages, selected]);
    } else {
      toast.error('You can only select up to four images.');
    }
  };

  const handleDeselectImage = (id) => {
    setSelectedImages(selectedImages.filter(image => image.id !== id));
  };

  const handleRemoveImage = (id) => {
    const newImages = images.filter(image => image.id !== id);
    setImages(newImages);
    setSidebarImages(newImages);
    setSelectedImages(selectedImages.filter(image => image.id !== id));
  };

  const handleUpload = () => {
    setSelectedImages([]);
  };

  const handleDownloadPDF = () => {
    const input = pdfRef.current;
    html2canvas(input, { scale: 2 }).then(canvas => {
      const imgData = canvas.toDataURL('image/png');
      const pdf = new jsPDF();
      pdf.text('Pathology images', 10, 10);
      pdf.addImage(imgData, 'PNG', 10, 20, 180, 240);
      pdf.save("pathology_images.pdf");
    });
  };

  return (
    <div className="container-fluid" ref={pdfRef}>
      <h1 className="text-center">Histopathology Data</h1>
      <div className="row">
        {/* <div className="col-md-8">
          {selectedImages.length > 0 && (
            <ImageViewer image={selectedImages[0].data} />
          )}
        </div> */}
        <div className="col-md-4">
          <div className="sidebar float-right">
            <h4>Loaded Images</h4>
            <div className="scrollbar">
              <ImageGallery
                items={sidebarImages.map(image => ({
                  original: `data:image/jpeg;base64,${image.data}`,
                  thumbnail: `data:image/jpeg;base64,${image.data}`
                }))}
                showPlayButton={false}
                onClick={(event) => {
                  const id = event.target.dataset.id;
                  const selectedImage = sidebarImages.find(image => image.id === id);
                  setSelectedImages([selectedImage]);
                }}
              />
            </div>
          </div>
        </div>
      </div>
      <ImageUploader patientId={props.patientId} onUpload={handleUpload} />
      <button className="btn btn-primary" onClick={handleDownloadPDF}>Download PDF</button>

    </div>
  );
  
}