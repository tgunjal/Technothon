package com.technothon.multimodel.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.technothon.multimodel.dao.HistopathologyImageRepository;
import com.technothon.multimodel.entity.HistopathologyImage;

@Service
public class HistopathologyServiceImpl implements HistopathologyService{

	@Autowired
	PatientService patientService;
	@Autowired 
	HistopathologyImageRepository imageRepository;
	@Override
	public List<HistopathologyImage> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistopathologyImage> findByCaseId(String id) {
		// TODO Auto-generated method stub
		return imageRepository.findAllById(id);
	}

	@Override
	public void save(HistopathologyImage histopathologyImage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int rid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll(List<HistopathologyImage> histopathologyImage) {
		// TODO Auto-generated method stub
		
	}


	public ResponseEntity<?> uploadImages(MultipartFile[] files, String patientId) throws IOException {
		  Map<String, String> response = new HashMap<>();
		  try {
			  List<HistopathologyImage> imageList = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            byte[] data = file.getBytes();
            HistopathologyImage image = new HistopathologyImage();
            image.setPatient(patientService.findByCaseId(patientId));
            image.setFileName(fileName);
            image.setData(data);
            imageList.add(image);
        	}
        imageRepository.saveAll(imageList);

        response.put("Uploaded", "Success");
	    return ResponseEntity.status(HttpStatus.OK).body(response);

        }
		  catch (IOException e) {
			  response.put("Failed to upload images:", "Failed");
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		    }
		}

	@Override
	public Optional<HistopathologyImage> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	}
