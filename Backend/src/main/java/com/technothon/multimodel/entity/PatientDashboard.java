package com.technothon.multimodel.entity;

public class PatientDashboard {

	private String id;

	private String age;
	
	private String weight;   
	
	private String survivalStatus;

	private String name;
	
	private String gender; 

	public PatientDashboard(String id, String age, String f, String survivalstatus, String patientName,
			String gender) {
		super();
		this.id = id;
		this.age = age;
		this.weight = f;
		this.survivalStatus = survivalstatus;
		this.name = patientName;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public void setName(String patientName) {
		this.name = patientName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public String getAge() {
		return age;
	}

	public String getWeight() {
		return weight;
	}

	public String getSurvivalStatus() {
		return survivalStatus;
	}

	public void setCaseId(String case_id) {
		this.id = case_id;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setSurvivalStatus(String survivalstatus) {
		this.survivalStatus = survivalstatus;
	} 
}
