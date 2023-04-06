package com.technothon.multimodel.services;

import java.util.List;
import java.util.Optional;

import com.technothon.multimodel.entity.BioMarker;
import com.technothon.multimodel.entity.BioMarkerChart;
import com.technothon.multimodel.entity.MutationCount;
import com.technothon.multimodel.entity.Mutationgraph;

public interface BiomarkerService {

	 public List<BioMarker> findAll();
	 public Optional<BioMarker> findById(int id);
	 public void save( BioMarker  bioMarker);
	 public void deleteById(int rid);
	 public void saveAll(List<BioMarker> bioMarker);
	 public BioMarkerChart findAllByList();




}
