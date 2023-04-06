package com.technothon.multimodel.services;

import java.util.List;
import java.util.Optional;

import com.technothon.multimodel.entity.Patient;


public interface PatientService {

	 public List<Patient> findAll();
	 public void save(Patient patient);
	 public void deleteById(String id);
		public void saveAll(List<Patient> clinicalData);
		public Patient findByCaseId(String id);
}
