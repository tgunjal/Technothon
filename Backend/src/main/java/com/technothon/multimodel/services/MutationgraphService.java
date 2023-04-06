package com.technothon.multimodel.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.technothon.multimodel.entity.MultiBarGraph;
import com.technothon.multimodel.entity.MutationCount;
import com.technothon.multimodel.entity.Mutationgraph;




public interface MutationgraphService {
	 public List<Mutationgraph> findAll();
	 public Optional<Mutationgraph> findById(int id);
	 public void save( Mutationgraph  mutationgraph);
	 public void deleteById(int caseId);
	 public void saveAll(List<Mutationgraph> mutationgraph);

	 public List<MutationCount> findAllByColumn();
	 	List<String> findByAllDates();

}
