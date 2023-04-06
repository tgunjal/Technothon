package com.technothon.multimodel.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.technothon.multimodel.entity.BioMarker;
import com.technothon.multimodel.entity.BioMarkerChart;
import com.technothon.multimodel.entity.HistopathologyImage;
import com.technothon.multimodel.entity.LaboratoryData;
import com.technothon.multimodel.entity.MutationCount;
import com.technothon.multimodel.entity.Mutationgraph;
import com.technothon.multimodel.entity.Patient;
import com.technothon.multimodel.entity.PatientDashboard;
import com.technothon.multimodel.helper.ExcelConversion;
import com.technothon.multimodel.services.BiomarkerServiceImpl;
import com.technothon.multimodel.services.HistopathologyServiceImpl;
import com.technothon.multimodel.services.LaboratoryDataServiceImpl;
import com.technothon.multimodel.services.MutationgraphImpl;
import com.technothon.multimodel.services.PatientServiceImpl;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {

	@Autowired
	PatientServiceImpl patientServiceImpl;
	@Autowired
	MutationgraphImpl mutationgraphImpl;
	@Autowired
	ExcelConversion excelConversion;
	@Autowired
	BiomarkerServiceImpl biomarkerImpl;
	@Autowired
	LaboratoryDataServiceImpl laboratoryDataImpl;
	@Autowired
	HistopathologyServiceImpl histopathologyServiceImpl;
	 @PostMapping(value = "/uploadPatientClinicalData")
	  public ResponseEntity<?> uploadPatientClinicalData(@RequestParam("file") MultipartFile file) throws IOException {
	    String message = "";

//	    if (Helper.hasExcelFormat(file)) {
	      
		patientServiceImpl.saveAll(excelConversion.excelToClinicalData(file.getInputStream()));
	    	
	        message= "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body("new ResponseMessage(message)");
//	      }
//	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	     
	  }
	 @PostMapping(value = "/create")
	 public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
	 patientServiceImpl.save(patient);
	 return ResponseEntity.status(HttpStatus.OK).body("Success");
	 }
	 
	
	 @GetMapping("/radiology/{patientId}")
	
	    public ResponseEntity<byte[]> getPatientImages(@PathVariable String patientId) {
	        String folderPath = "C:\\Users\\tanmay_gunjal\\Downloads\\db\\" + patientId;
	        File folder = new File(folderPath);

	        if (!folder.exists() || !folder.isDirectory()) {
	            return ResponseEntity.notFound().build();
	        }

	        List<File> imageFiles = new ArrayList<>();
	        collectImageFiles(folder, imageFiles);

	        if (imageFiles.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            byte[] combinedImageData = combineImageFiles(imageFiles);
	            return ResponseEntity.ok()
	                    .contentType(MediaType.IMAGE_JPEG)
	                    .body(combinedImageData);
	        }
	        
	    }

	    private void collectImageFiles(File folder, List<File> imageFiles) {
	        for (File file : folder.listFiles()) {
	            if (file.isDirectory()) {
	                collectImageFiles(file, imageFiles);
	            } else if (file.isFile() && file.getName().endsWith(".dcm")) {
	                imageFiles.add(file);
	            }
	        }
	    }

	    private byte[] combineImageFiles(List<File> imageFiles) {
	        ByteArrayOutputStream output = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int bytesRead;
	        for (File file : imageFiles) {
	            try (FileInputStream input = new FileInputStream(file)) {
	                while ((bytesRead = input.read(buffer)) != -1) {
	                    output.write(buffer, 0, bytesRead);
	                }
	            } catch (IOException e) {
	                // Log the exception, but continue processing the rest of the files
	                e.printStackTrace();
	            }
	        }
	        return output.toByteArray();
	    }
	 @GetMapping(value = "/get")
	 public ResponseEntity<List<PatientDashboard>> getRecords() {
		 List<Patient> patientList = patientServiceImpl.findAll();
	 List<PatientDashboard> patientDashboardList = new ArrayList<>();
	 
	  for(Patient p : patientList) 
		  patientDashboardList.add(new PatientDashboard(p.getCaseId(), p.getAge(), p.getWeightLbs(), p.getSurvivalStatus(), p.getPatientName(), p.getGender()));
		  
	 
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(patientDashboardList);
	 
	 }
	 
	 
	 @GetMapping(value = "/getPatientMutation")
	 public ResponseEntity<List<Mutationgraph>> getPatientMutation() {
		 return ResponseEntity.status(HttpStatus.OK).body(mutationgraphImpl.findAll());
		
		 
	 }
	 
	 @PostMapping(value ="/uploadmutation")
	    public ResponseEntity<?> uploadGenericData(@RequestParam("file") MultipartFile file) {
	        if (file.isEmpty()) {
	        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	        }
	        
	        try {
	            // Read data from the Excel file
	            List<Mutationgraph> patients = ExcelConversion.readExcelFile(file.getInputStream());

	            // Save data to the database
	            mutationgraphImpl.saveAll(patients);

	            return ResponseEntity.status(HttpStatus.OK).body("Data has been uploaded successfully!");
	        } catch (IOException e) {
	        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
	        }
	    }
	 
	 
	 @PostMapping(value ="/uploadBiomarkerData")
	    public ResponseEntity<?> uploadBiomarkerData(@RequestParam("file") MultipartFile file) {
	        if (file.isEmpty()) {
	        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	        }
	        
	        try {
	            // Read data from the Excel file
	            List<BioMarker> bioMarkerData = ExcelConversion.readBiomarkerData(file.getInputStream());

	            // Save data to the database
	            biomarkerImpl.saveAll(bioMarkerData);

	            return ResponseEntity.status(HttpStatus.OK).body("Data has been uploaded successfully!");
	        } catch (IOException e) {
	        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
	        }
	    }
	 
	 @PostMapping(value ="/uploadLaboratoryData")
	    public ResponseEntity<?> uploadLaboratoryData(@RequestParam("file") MultipartFile file) {
	        if (file.isEmpty()) {
	        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	        }
	        
	        try {
	            // Read data from the Excel file
	            List<LaboratoryData> laboratoryData = ExcelConversion.readLaboratoryData(file.getInputStream());

	            // Save data to the database
	            laboratoryDataImpl.saveAll(laboratoryData);

	            return ResponseEntity.status(HttpStatus.OK).body("Data has been uploaded successfully!");
	        } catch (IOException e) {
	        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
	        }
	    }
	 @GetMapping(value = "/getLaboratoryData")
	 public ResponseEntity<List<LaboratoryData>> getLaboratoryData() {

		  
		 return ResponseEntity.status(HttpStatus.OK).body(laboratoryDataImpl.findAll());
		 		 
	 }
	 
	 @GetMapping(value = "/getClinicalData/{caseId}")
	 public ResponseEntity<Patient> getClinicalData(@PathVariable String caseId) {

		  
		 return ResponseEntity.status(HttpStatus.OK).body(patientServiceImpl.findByCaseId(caseId));
		 		 
	 }
	 @GetMapping(value = "/getBiomarkerData")
	 public ResponseEntity<BioMarkerChart> getBiomarkerData() {

		  
		 return ResponseEntity.status(HttpStatus.OK).body(biomarkerImpl.findAllByList());
		 		 
	 }
	 @GetMapping(value = "/getMutationCount")
	 public ResponseEntity<List<MutationCount>> getMutationCount() {

		  
		 return ResponseEntity.status(HttpStatus.OK).body(mutationgraphImpl.findAllByColumn());
		 		 
	 }
	 
	 @GetMapping(value = "/getMutationCountDates")
	 public ResponseEntity<List<String>> getMutationCountDates() {

		  
		 return ResponseEntity.status(HttpStatus.OK).body(mutationgraphImpl.findByAllDates());
		 		 
	 }
	  @PostMapping("/uploadHistopathologyData/{caseId}")
	    public ResponseEntity<?> uploadHistopathologyData(@RequestParam(value  = "files") MultipartFile[] files,
	    		@PathVariable String caseId) {
		  Map<String, String> response = new HashMap<>();
	       
	        	try {
					return histopathologyServiceImpl.uploadImages(files, caseId);
				} catch (IOException e) {
					 response.put("Failed to upload images:", "Failed");
			            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
				}
	        
	        	
	        	
	       
	    }
		 @GetMapping(value = "/getPathologyImages/{caseId}")
		 public ResponseEntity<List<HistopathologyImage>> getPathologyImages(@PathVariable String caseId) {

			  
			 return ResponseEntity.status(HttpStatus.OK).body(histopathologyServiceImpl.findByCaseId(caseId));
			 		 
		 }
	
}
