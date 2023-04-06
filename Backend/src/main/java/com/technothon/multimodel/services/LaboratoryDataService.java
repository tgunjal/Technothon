package com.technothon.multimodel.services;

import java.util.List;
import java.util.Optional;

import com.technothon.multimodel.entity.LaboratoryData;

public interface LaboratoryDataService {

	 public List<LaboratoryData> findAll();
	 public Optional<LaboratoryData> findById(int id);
	 public void save( LaboratoryData  laboratoryData);
	 public void deleteById(int rid);
	 public void saveAll(List<LaboratoryData> laboratoryData);
	 public LaboratoryData findAllByList();

}
