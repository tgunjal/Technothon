package com.technothon.multimodel.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technothon.multimodel.entity.BioMarker;
import com.technothon.multimodel.entity.LaboratoryData;
import com.technothon.multimodel.entity.Mutationgraph;
import com.technothon.multimodel.entity.Patient;
import com.technothon.multimodel.services.PatientServiceImpl;

@Service
public class ExcelConversion {


	@Autowired
	PatientServiceImpl patientServiceImpl;
	 public static List<Patient>  excelToClinicalData(InputStream is) throws IOException {
	        Workbook workbook = new XSSFWorkbook(is);
	        Sheet sheet = workbook.getSheetAt(0);
	        Iterator<Row> rows = sheet.iterator();

	        List<Patient> patientList = new ArrayList<>();
           

	        int rowNumber = 0;

	
	        while (rows.hasNext()) {
	            Row currentRow = rows.next();

	            // Skip header row
	            if (rowNumber == 0) {
	                rowNumber++;
	                continue;
	            }

	            Iterator<Cell> cellsInRow = currentRow.iterator();

	            Patient patient = new Patient();

	            int cellIndex = 0;
	            while (cellsInRow.hasNext()) {
                Cell currentCell = cellsInRow.next();

	            	
	            	switch(cellIndex) {
	            	case 0 : patient.setCaseId(currentCell.getStringCellValue());
	            		   break;
	            	case 1 : patient.setPatientName(currentCell.getStringCellValue());
	            			break;
	            	case 2 : patient.setPatientAffiliation(currentCell.getStringCellValue());
	            			break;
	            	case 3 : 
		
			             	if (currentCell.getCellType() == CellType.NUMERIC) {
			            		patient.setAge(String.valueOf(currentCell.getNumericCellValue()));
		                	} else {
		                		patient.setAge(currentCell.getStringCellValue());
		                	}
	            			break;
	            	case 4 : 
			
				             	if (currentCell.getCellType() == CellType.NUMERIC) {
				            		patient.setWeightLbs(String.valueOf(currentCell.getNumericCellValue()));
			                	} else {
			                		patient.setWeightLbs(currentCell.getStringCellValue());
			                	}
         		   			break;
	            	case 5 : patient.setGender(currentCell.getStringCellValue());
	            			break;
	            	case 6 : patient.setEthnicity(currentCell.getStringCellValue());
	            			break;
	            	case 7 : patient.setSmokingStatus(currentCell.getStringCellValue());
	            			break;
	            	case 8 : 
				             	if (currentCell.getCellType() == CellType.NUMERIC) {
				            		patient.setPackYears(String.valueOf(currentCell.getNumericCellValue()));
			                	} else {
			                		patient.setPackYears(currentCell.getStringCellValue());
			                	}
	            			break;
	            	case 9 : 
				             	if (currentCell.getCellType() == CellType.NUMERIC) {
				            		patient.setQuitSmokingYear(String.valueOf(currentCell.getNumericCellValue()));
			                	} else {
			                		patient.setQuitSmokingYear(currentCell.getStringCellValue());
			                	}
	            			break;
	            	case 10 : patient.setKrasMutationStatus(currentCell.getStringCellValue());
	            			break;
	 
	            	case 11 : patient.setAlkTranslocationStatus(currentCell.getStringCellValue());
	            			break;
	            	case 12 : patient.setAdjuvantTreatment(currentCell.getStringCellValue());
	            			break;
	            	case 13 : patient.setChemotherapy(currentCell.getStringCellValue());
	            			break;
	            	case 14 : patient.setRadiation(currentCell.getStringCellValue());
	            			break;
	            	case 15 : patient.setRecurrence(currentCell.getStringCellValue());
	            			break;
	            	case 16 : 
	                 	if (currentCell.getCellType() == CellType.STRING) {
		             		patient.setDateOfRecurrence(currentCell.getStringCellValue());
		            		
	                	} else {
	                		patient.setDateOfRecurrence(String.valueOf(currentCell.getLocalDateTimeCellValue()));
	                	}

            			break;
         		   
	            	case 17 :
	                	if (currentCell.getCellType() == CellType.STRING) {
		             		patient.setDateOfLastKnownAlive(currentCell.getStringCellValue());
		            		
	                	} else {
	                		patient.setDateOfLastKnownAlive(String.valueOf(currentCell.getLocalDateTimeCellValue()));
	                	}

         		   break;
	            	case 18 : patient.setSurvivalStatus(currentCell.getStringCellValue());
         		   break;
	            	case 19 :  
	                  	if (currentCell.getCellType() == CellType.STRING) {
		             		patient.setDateOfDeath(currentCell.getStringCellValue());
		            		
	                	} else {
	                		patient.setDateOfDeath(String.valueOf(currentCell.getLocalDateTimeCellValue()));
	                	}
	                  	
	            	
         		   break;
	            	case 20 : 
			            	if (currentCell.getCellType() == CellType.NUMERIC) {
			            		patient.setTimeToDeathDays(String.valueOf(currentCell.getNumericCellValue()));
		                	} else {
		                		patient.setTimeToDeathDays(currentCell.getStringCellValue());
		                	}
	            			break;
	            	case 21 : 
	             	if (currentCell.getCellType() == CellType.STRING) {
	             		patient.setCtDate(currentCell.getStringCellValue());
	            		
                	} else {
                		patient.setCtDate(String.valueOf(currentCell.getLocalDateTimeCellValue()));
                	}
	            		break;
	            	case 22 : 
	             	if (currentCell.getCellType() == CellType.NUMERIC) {
	            		patient.setDaysBetweenCtAndSurgery(String.valueOf(currentCell.getNumericCellValue()));
                	} else {
                		patient.setDaysBetweenCtAndSurgery(currentCell.getStringCellValue());
                	}
         		   break;
	            	case 23 :
	            	if (currentCell.getCellType() == CellType.NUMERIC) {
	            		patient.setContactNumber(String.valueOf(currentCell.getNumericCellValue()));
                	} else {
                		patient.setContactNumber(currentCell.getStringCellValue());
                	}
         		   break;
	            	case 24 : patient.setEmail(currentCell.getStringCellValue());
         		   break;
	            	case 25 : patient.setAddress(currentCell.getStringCellValue());
         		   break;
	            	case 26 : patient.setBloodGroup(currentCell.getStringCellValue());
         		   break;

	                }
	            	cellIndex++;
	           }
	            patientList.add(patient);
	            }
	        workbook.close();
		 return patientList;
	 }
	 
	 
	 
	   public static List<Mutationgraph> readExcelFile(InputStream is) throws IOException {
	        Workbook workbook = new XSSFWorkbook(is);
	        Sheet sheet = workbook.getSheetAt(0);
	        Iterator<Row> rows = sheet.iterator();

	        List<Mutationgraph> mutationgraphList = new ArrayList<>();

	        int rowNumber = 0;
	        while (rows.hasNext()) {
	            Row currentRow = rows.next();

	            // Skip header row
	            if (rowNumber == 0) {
	                rowNumber++;
	                continue;
	            }

	            Iterator<Cell> cellsInRow = currentRow.iterator();

	            Mutationgraph mutationgraph = new Mutationgraph();

	            int cellIndex = 0;
	            while (cellsInRow.hasNext()) {
	                Cell currentCell = cellsInRow.next();
	                if (cellIndex == 0) { // Date
	                	if (currentCell.getCellType() == CellType.NUMERIC) {
	                	    mutationgraph.setDate(currentCell.getDateCellValue());
	                	} else {
	                	    mutationgraph.setDate(new Date(currentCell.getStringCellValue()));
	                	}
	                }else
	                if (cellIndex == 1) { // Age
	                	mutationgraph.setAge((int) currentCell.getNumericCellValue());
	 	                }else
	 	                   if (cellIndex == 2) { // Smoking Status
		 	                	mutationgraph.setSmokingStatus(currentCell.getStringCellValue());
		 	                }else
		 	                   if (cellIndex == 3) { // Cancer Stage
		 	                	 	mutationgraph.setCancerStage(currentCell.getStringCellValue());
			 	                }else
	                if (cellIndex == 4) { // mutation count
	                	mutationgraph.setMutationCount((int) currentCell.getNumericCellValue());
	                } else if (cellIndex == 5) { // KRAS mutation count
	                	mutationgraph.setKrasMutationCount((int) currentCell.getNumericCellValue());
	                } else if (cellIndex == 6) { // EGFR mutation count
	                	mutationgraph.setEgfrMutationCount((int) currentCell.getNumericCellValue());
	                }  
	                //TP53 Mutation Count
	                else if (cellIndex == 7) { 
	                	mutationgraph.setTp53MutationCount((int) currentCell.getNumericCellValue());
	                }  
	                else if (cellIndex == 8) { // ALK Fusion Status
	                	mutationgraph.setAlkFusionStatus(currentCell.getStringCellValue());
	                }  
	                else if (cellIndex == 9) { // ROS1 Fusion Status
	                	mutationgraph.setRos1FusionStatus(currentCell.getStringCellValue());
	                }  
	                else if (cellIndex == 10) { // Treatment
	                	mutationgraph.setTreatment(currentCell.getStringCellValue());
	                }  
	                else if (cellIndex == 11) { // Response
	                	mutationgraph.setResponse(currentCell.getStringCellValue());
	                } 
	                cellIndex++;
	            }

	            mutationgraphList.add(mutationgraph);
	        }

	        workbook.close();

	        return mutationgraphList;
	    }
	   
	   public static List<LaboratoryData> readLaboratoryData(InputStream is) throws IOException {
		    Workbook workbook = new XSSFWorkbook(is);
	        Sheet sheet = workbook.getSheetAt(0);
	        Iterator<Row> rows = sheet.iterator();

	        List<LaboratoryData> laboratoryDataList = new ArrayList<>();
           

	        int rowNumber = 0;

	
	        while (rows.hasNext()) {
	            Row currentRow = rows.next();

	            // Skip header row
	            if (rowNumber == 0) {
	                rowNumber++;
	                continue;
	            }

	            Iterator<Cell> cellsInRow = currentRow.iterator();

	            LaboratoryData laboratoryData = new LaboratoryData();

	            int cellIndex = 0;
	            while (cellsInRow.hasNext()) {
	                Cell currentCell = cellsInRow.next();
	               if (cellIndex == 0) { // Date
	            	   laboratoryData.setDate(currentCell.getStringCellValue());
	                }
	               else    if (cellIndex == 1) { // Date
	            	   laboratoryData.setWBCCount(((Double) currentCell.getNumericCellValue()));
                } else   if (cellIndex == 2) { // Date
	            	   laboratoryData.setRBCCount(((Double) currentCell.getNumericCellValue()));
             }
	               if (cellIndex == 3) { // Date
	            	   laboratoryData.setHemoglobin(((Double) currentCell.getNumericCellValue()));
                }
	               if (cellIndex == 4) { // Date
	            	   laboratoryData.setHematocrit(((Double) currentCell.getNumericCellValue()));
                }
	               if (cellIndex == 5) { // Date
	            	   laboratoryData.setPlateletCount(((Double) currentCell.getNumericCellValue()));
                }
	               if (cellIndex == 6) { // Date
	            	   laboratoryData.setSodium(((Double) currentCell.getNumericCellValue()));
                }
	               if (cellIndex == 7) { // Date
	            	   laboratoryData.setPotassium(((Double) currentCell.getNumericCellValue()));
                }
	               if (cellIndex == 8) { // Date
	            	   laboratoryData.setChloride(((Double) currentCell.getNumericCellValue()));
                }
	               cellIndex++;
	           
	                }
	            laboratoryDataList.add(laboratoryData);
	            }
	        workbook.close();
	        return laboratoryDataList;
	   }
	   
	   
	   public static List<BioMarker> readBiomarkerData(InputStream is) throws IOException {
	        Workbook workbook = new XSSFWorkbook(is);
	        Sheet sheet = workbook.getSheetAt(0);
	        Iterator<Row> rows = sheet.iterator();

	        List<BioMarker> bioMarkerList = new ArrayList<>();
           

	        int rowNumber = 0;

	
	        while (rows.hasNext()) {
	            Row currentRow = rows.next();

	            // Skip header row
	            if (rowNumber == 0) {
	                rowNumber++;
	                continue;
	            }

	            Iterator<Cell> cellsInRow = currentRow.iterator();

	            BioMarker bioMarker = new BioMarker();

	            int cellIndex = 0;
	            while (cellsInRow.hasNext()) {
	                Cell currentCell = cellsInRow.next();
	               if (cellIndex == 0) { // Date
	                       bioMarker.setTime((int) currentCell.getNumericCellValue());
	                }
	               else    if (cellIndex == 1) { // Date
                       bioMarker.setCtcCount(((int) currentCell.getNumericCellValue()));
                } else {
                	bioMarker.setOnCologyMilestone(currentCell.getStringCellValue());
                }
	               cellIndex++;
	           
	                }
	            bioMarkerList.add(bioMarker);
	            }
	        workbook.close();
	        return bioMarkerList;
	   }
	            
}
