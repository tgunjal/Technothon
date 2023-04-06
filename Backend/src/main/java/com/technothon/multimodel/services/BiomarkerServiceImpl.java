package com.technothon.multimodel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technothon.multimodel.dao.BioMarkerRepository;
import com.technothon.multimodel.entity.BioMarker;
import com.technothon.multimodel.entity.BioMarkerChart;

@Service
public class BiomarkerServiceImpl implements BiomarkerService {

	@Autowired
	BioMarkerRepository bioMarkerRepository;
	
	@Override
	public List<BioMarker> findAll() {
		// TODO Auto-generated method stub
		return bioMarkerRepository.findAll();
	}

	@Override
	public Optional<BioMarker> findById(int id) {
		// TODO Auto-generated method stub
		return bioMarkerRepository.findById(id);
	}

	@Override
	public void save(BioMarker bioMarker) {
		// TODO Auto-generated method stub
		bioMarkerRepository.save(bioMarker);
	}

	@Override
	public void deleteById(int rid) {
		
		bioMarkerRepository.deleteById(rid);
	}

	@Override
	public void saveAll(List<BioMarker> bioMarker) {
		bioMarkerRepository.saveAll(bioMarker);
		
	}
	public BioMarkerChart findAllByList() {
		BioMarkerChart bioMarkerChart = new BioMarkerChart();
		
		List<BioMarker> bioMarkerList = bioMarkerRepository.findAll();
		List<Integer> timeList = new ArrayList<>();
		List<Integer> ctcList = new ArrayList<>();
		List<String> milestoneData = new ArrayList<>();
		for(BioMarker b: bioMarkerList) {
			timeList.add(b.getTime());
			ctcList.add(b.getCtcCount());
			milestoneData.add(b.getOnCologyMilestone());
		}
		bioMarkerChart.setTimeData(timeList);
		bioMarkerChart.setCtcCountData(ctcList);
		bioMarkerChart.setMilestoneData(milestoneData);
		return bioMarkerChart;
	}

}
