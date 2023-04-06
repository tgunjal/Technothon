package com.technothon.multimodel.entity;

import java.util.List;

public class BioMarkerChart {

	List<Integer> timeData;
	List<Integer> ctcCountData;
	List<String> milestoneData;
	public List<Integer> getTimeData() {
		return timeData;
	}
	public List<Integer> getCtcCountData() {
		return ctcCountData;
	}
	public List<String> getMilestoneData() {
		return milestoneData;
	}
	public void setTimeData(List<Integer> timeData) {
		this.timeData = timeData;
	}
	public void setCtcCountData(List<Integer> ctcCountData) {
		this.ctcCountData = ctcCountData;
	}
	public void setMilestoneData(List<String> milestoneData) {
		this.milestoneData = milestoneData;
	}
	
}
