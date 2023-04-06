package com.technothon.multimodel.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.technothon.multimodel.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {
	
	@Query("FROM Patient pd WHERE pd.caseId = (:caseId)")
	  Patient findByCaseId(String caseId);

}
