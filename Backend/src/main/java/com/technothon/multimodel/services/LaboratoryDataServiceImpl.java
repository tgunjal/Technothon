package com.technothon.multimodel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technothon.multimodel.dao.LaboratoryDataRepository;
import com.technothon.multimodel.entity.LaboratoryData;

@Service
public class LaboratoryDataServiceImpl implements LaboratoryDataService {

	@Autowired
	LaboratoryDataRepository laboratoryDataRepository;
	@Override
	public List<LaboratoryData> findAll() {
		// TODO Auto-generated method stub
		return laboratoryDataRepository.findAll();
	}

	@Override
	public Optional<LaboratoryData> findById(int id) {
		// TODO Auto-generated method stub
		return laboratoryDataRepository.findById(id);
	}

	@Override
	public void save(LaboratoryData laboratoryData) {
		// TODO Auto-generated method stub
		laboratoryDataRepository.save(laboratoryData);

	}

	@Override
	public void deleteById(int rid) {
		// TODO Auto-generated method stub
		laboratoryDataRepository.deleteById(rid);
	}

	@Override
	public void saveAll(List<LaboratoryData> laboratoryData) {
		// TODO Auto-generated method stub
		laboratoryDataRepository.saveAll(laboratoryData);
	}

	@Override
	public LaboratoryData findAllByList() {
		// TODO Auto-generated method stub
		return null;
	}

}
