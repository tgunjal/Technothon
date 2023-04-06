package com.technothon.multimodel.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Mutationgraph {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Nullable
    private Date date;
    
    @Column(name = "age")
    private int age;
    

    
    @Column(name = "smoking_status")
    private String smokingStatus;
    
    @Column(name = "cancer_stage")
    private String cancerStage;
    
    @Column(name = "mutation_count")
    private int mutationCount;
    
    @Column(name = "kras_mutation_count")
    private int krasMutationCount;
    
    @Column(name = "egfr_mutation_count")
    private int egfrMutationCount;
    
    @Column(name = "tp53_mutation_count")
    private int tp53MutationCount;
    
    @Column(name = "alk_fusion_status")
    private String alkFusionStatus;
    
    @Column(name = "ros1_fusion_status")
    private String ros1FusionStatus;
    
    @Column(name = "treatment")
    private String treatment;
    
    @Column(name = "response")
    private String response;

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public int getAge() {
		return age;
	}

	public String getSmokingStatus() {
		return smokingStatus;
	}

	public String getCancerStage() {
		return cancerStage;
	}

	public int getMutationCount() {
		return mutationCount;
	}

	public int getKrasMutationCount() {
		return krasMutationCount;
	}

	public int getEgfrMutationCount() {
		return egfrMutationCount;
	}

	public int getTp53MutationCount() {
		return tp53MutationCount;
	}

	public String getAlkFusionStatus() {
		return alkFusionStatus;
	}

	public String getRos1FusionStatus() {
		return ros1FusionStatus;
	}

	public String getTreatment() {
		return treatment;
	}

	public String getResponse() {
		return response;
	}

	public void setId(int i) {
		this.id = i;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSmokingStatus(String smokingStatus) {
		this.smokingStatus = smokingStatus;
	}

	public void setCancerStage(String cancerStage) {
		this.cancerStage = cancerStage;
	}

	public void setMutationCount(int mutationCount) {
		this.mutationCount = mutationCount;
	}

	public void setKrasMutationCount(int krasMutationCount) {
		this.krasMutationCount = krasMutationCount;
	}

	public void setEgfrMutationCount(int egfrMutationCount) {
		this.egfrMutationCount = egfrMutationCount;
	}

	public void setTp53MutationCount(int tp53MutationCount) {
		this.tp53MutationCount = tp53MutationCount;
	}

	public void setAlkFusionStatus(String alkFusionStatus) {
		this.alkFusionStatus = alkFusionStatus;
	}

	public void setRos1FusionStatus(String ros1FusionStatus) {
		this.ros1FusionStatus = ros1FusionStatus;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public void setResponse(String response) {
		this.response = response;
	}



    // getters and setters

}
