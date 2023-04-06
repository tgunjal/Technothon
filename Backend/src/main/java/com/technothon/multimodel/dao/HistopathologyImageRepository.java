package com.technothon.multimodel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.technothon.multimodel.entity.HistopathologyImage;

public interface HistopathologyImageRepository extends JpaRepository<HistopathologyImage, String> {

	
	@Query("FROM HistopathologyImage h WHERE h.patient.caseId = (:id)")
	public List<HistopathologyImage> findAllById(String id);
	
	
	
}
