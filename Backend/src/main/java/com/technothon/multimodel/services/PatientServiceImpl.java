package com.technothon.multimodel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technothon.multimodel.dao.PatientRepo;
import com.technothon.multimodel.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepo patientRepo;
	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}



	@Override
	public void save(Patient patient) {
		// TODO Auto-generated method stub
		
		System.out.print(patient.getAge() + " ______________________________");
			patientRepo.save(patient);
	}



	@Override
	public void deleteById(String caseId) {
		// TODO Auto-generated method stub
//		patientRepo.deleteByCaseId(caseId);
		
	}

	public void saveAll(List<Patient> clinicalData) {
		// TODO Auto-generated method stub 
		patientRepo.saveAll(clinicalData);
		
	}

	@Override
	public Patient findByCaseId(String id) {
		// TODO Auto-generated method stub
		return patientRepo.findByCaseId(id);
	}

}
