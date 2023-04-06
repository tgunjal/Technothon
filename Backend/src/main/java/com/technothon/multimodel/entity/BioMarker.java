package com.technothon.multimodel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BioMarker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rid")
	private Integer rid;
	
	@Column(name="time")
	int time;
	
	@Column(name="ctc_count")
	int ctcCount;
	
	@Column(name="on_cology_milestone")
	String onCologyMilestone;

	public BioMarker() {
		
	}
	public BioMarker(Integer rid, int time, int ctcCount, String onCologyMilestone) {
		super();
		this.rid = rid;
		this.time = time;
		this.ctcCount = ctcCount;
		this.onCologyMilestone = onCologyMilestone;
	}

	public Integer getRid() {
		return rid;
	}

	public int getTime() {
		return time;
	}

	public int getCtcCount() {
		return ctcCount;
	}

	public String getOnCologyMilestone() {
		return onCologyMilestone;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setCtcCount(int ctcCount) {
		this.ctcCount = ctcCount;
	}

	public void setOnCologyMilestone(String onCologyMilestone) {
		this.onCologyMilestone = onCologyMilestone;
	}
	
	
}
