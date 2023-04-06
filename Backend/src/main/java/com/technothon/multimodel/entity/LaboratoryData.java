package com.technothon.multimodel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LaboratoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "WBC_count")
    private Double WBCCount;

    @Column(name = "RBC_count")
    private Double RBCCount;

    @Column(name = "hemoglobin")
    private Double hemoglobin;

    @Column(name = "hematocrit")
    private Double hematocrit;

    @Column(name = "platelet_count")
    private Double plateletCount;

    @Column(name = "sodium")
    private Double sodium;

    @Column(name = "potassium")
    private Double potassium;

    @Column(name = "chloride")
    private Double chloride;

    
    public LaboratoryData() {
    	
    }
	public Long getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public Double getWBCCount() {
		return WBCCount;
	}

	public Double getRBCCount() {
		return RBCCount;
	}

	public Double getHemoglobin() {
		return hemoglobin;
	}

	public Double getHematocrit() {
		return hematocrit;
	}

	public Double getPlateletCount() {
		return plateletCount;
	}

	public Double getSodium() {
		return sodium;
	}

	public Double getPotassium() {
		return potassium;
	}

	public Double getChloride() {
		return chloride;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setWBCCount(Double wBCCount) {
		WBCCount = wBCCount;
	}

	public void setRBCCount(Double rBCCount) {
		RBCCount = rBCCount;
	}

	public void setHemoglobin(Double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}

	public void setHematocrit(Double hematocrit) {
		this.hematocrit = hematocrit;
	}

	public void setPlateletCount(Double plateletCount) {
		this.plateletCount = plateletCount;
	}

	public void setSodium(Double sodium) {
		this.sodium = sodium;
	}

	public void setPotassium(Double potassium) {
		this.potassium = potassium;
	}

	public void setChloride(Double chloride) {
		this.chloride = chloride;
	}

}
