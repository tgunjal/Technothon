package com.technothon.multimodel.services;

import java.util.List;
import java.util.Optional;

import com.technothon.multimodel.entity.HistopathologyImage;


public interface HistopathologyService {
	 public List<HistopathologyImage> findAll();
	 public Optional<HistopathologyImage> findById(int id);
	 public void save( HistopathologyImage  histopathologyImage);
	 public void deleteById(int rid);
	 public void saveAll(List<HistopathologyImage> histopathologyImage);
	 
	 public List<HistopathologyImage> findByCaseId(String id);

}
