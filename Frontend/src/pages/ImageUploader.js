import React, { useState } from 'react';
import { toast } from 'react-toastify';
const ImageUploader = (props) => {
  const [selectedFolder, setSelectedFolder] = useState(null);

  const handleUpload = () => {
    if (selectedFolder) {
      const formData = new FormData();
      for (let i = 0; i < selectedFolder.length; i++) {
        formData.append('files', selectedFolder[i]);
      }
      

      fetch(`http://localhost:8080/patient/uploadHistopathologyData/${props.patientId}`, {
        method: 'POST',
        body: formData,
      })
        .then(response => {
          if (response.ok) {
            toast.success('Images uploaded successfully!');
          } else {
            toast.error('Failed to upload images.');
          }
        })
        .catch(error => {
          console.error(error);
          toast.error('An error occurred while uploading images.');
        });
    }
  }
    const handleSelectFolder = (event) => {
      setSelectedFolder(event.target.files);
    };

    return (
      <div>
        <input
          type="file"
          accept="image/*"
          directory=""
          webkitdirectory=""
          onChange={handleSelectFolder}
        />
        <button onClick={handleUpload}>Upload</button>
      </div>
    );
  };

export default ImageUploader;
