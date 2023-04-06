package com.technothon.multimodel.entity;

import java.util.Date;
import java.util.List;

public class MultiBarGraph {

	private List<Integer> id;
    private  List<Date> date;
    private List<Integer> age;
    private List<String> smokingStatus;
    private List<String> cancerStage;
    private List<Integer> mutationCount;
    private List<Integer> krasMutationCount;
    private List<Integer> egfrMutationCount;
    private List<Integer> tp53MutationCount;
    private List<String> alkFusionStatus;
    private List<String> ros1FusionStatus;
    private List<String> treatment;
    private List<String> response;
	public List<Integer> getId() {
		return id;
	}
	public List<Date> getDate() {
		return date;
	}
	public List<Integer> getAge() {
		return age;
	}
	public List<String> getSmokingStatus() {
		return smokingStatus;
	}
	public List<String> getCancerStage() {
		return cancerStage;
	}
	public List<Integer> getMutationCount() {
		return mutationCount;
	}
	public List<Integer> getKrasMutationCount() {
		return krasMutationCount;
	}
	public List<Integer> getEgfrMutationCount() {
		return egfrMutationCount;
	}
	public List<Integer> getTp53MutationCount() {
		return tp53MutationCount;
	}
	public List<String> getAlkFusionStatus() {
		return alkFusionStatus;
	}
	public List<String> getRos1FusionStatus() {
		return ros1FusionStatus;
	}
	public List<String> getTreatment() {
		return treatment;
	}
	public List<String> getResponse() {
		return response;
	}
	public void setId(List<Integer> id) {
		this.id = id;
	}
	public void setDate(List<Date> date) {
		this.date = date;
	}
	public void setAge(List<Integer> age) {
		this.age = age;
	}
	public void setSmokingStatus(List<String> smokingStatus) {
		this.smokingStatus = smokingStatus;
	}
	public void setCancerStage(List<String> cancerStage) {
		this.cancerStage = cancerStage;
	}
	public void setMutationCount(List<Integer> mutationCount) {
		this.mutationCount = mutationCount;
	}
	public void setKrasMutationCount(List<Integer> krasMutationCount) {
		this.krasMutationCount = krasMutationCount;
	}
	public void setEgfrMutationCount(List<Integer> egfrMutationCount) {
		this.egfrMutationCount = egfrMutationCount;
	}
	public void setTp53MutationCount(List<Integer> tp53MutationCount) {
		this.tp53MutationCount = tp53MutationCount;
	}
	public void setAlkFusionStatus(List<String> alkFusionStatus) {
		this.alkFusionStatus = alkFusionStatus;
	}
	public void setRos1FusionStatus(List<String> ros1FusionStatus) {
		this.ros1FusionStatus = ros1FusionStatus;
	}
	public void setTreatment(List<String> treatment) {
		this.treatment = treatment;
	}
	public void setResponse(List<String> response) {
		this.response = response;
	}
    
}
