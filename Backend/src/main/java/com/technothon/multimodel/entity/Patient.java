package com.technothon.multimodel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Patient {
    
   
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    @Column(name = "case_id")
    private String caseId;
    
    @Column(name = "patient_name")
    private String patientName;
    
    @Column(name = "patient_affiliation")
    private String patientAffiliation;
    
    @Column(name = "age")
    private String age;
    
    @Column(name = "weight_lbs")
    private String weightLbs;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "ethnicity")
    private String ethnicity;
    
    @Column(name = "smoking_status")
    private String smokingStatus;
    
    @Column(name = "pack_years")
    private String packYears;
    
    @Column(name = "quit_smoking_year")
    private String quitSmokingYear;
    
    @Column(name = "kras_mutation_status")
    private String krasMutationStatus;
    
    @Column(name = "alk_translocation_status")
    private String alkTranslocationStatus;
    
    @Column(name = "adjuvant_treatment")
    private String adjuvantTreatment;
    
    @Column(name = "chemotherapy")
    private String chemotherapy;
    
    @Column(name = "radiation")
    private String radiation;
    
    @Column(name = "recurrence")
    private String recurrence;
    
    @Column(name = "date_of_recurrence")
    private String dateOfRecurrence;
    
    @Column(name = "date_of_last_known_alive")
    private String dateOfLastKnownAlive;
    
    @Column(name = "survival_status")
    private String survivalStatus;
    
    @Column(name = "date_of_death")
    private String dateOfDeath;
    
    @Column(name = "time_to_death_days")
    private String timeToDeathDays;
    
    @Column(name = "ct_date")
    private String ctDate;
    
    @Column(name = "days_between_ct_and_surgery")
    private String daysBetweenCtAndSurgery;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "blood_group")
    private String bloodGroup;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistopathologyImage> images = new ArrayList<>();
    
    
	public List<HistopathologyImage> getImages() {
		return images;
	}

	public void setImages(List<HistopathologyImage> images) {
		this.images = images;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Long getId() {
		return id;
	}

	public String getCaseId() {
		return caseId;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getPatientAffiliation() {
		return patientAffiliation;
	}

	public String getAge() {
		return age;
	}

	public String getWeightLbs() {
		return weightLbs;
	}

	public String getGender() {
		return gender;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public String getSmokingStatus() {
		return smokingStatus;
	}

	public String getPackYears() {
		return packYears;
	}

	public String getQuitSmokingYear() {
		return quitSmokingYear;
	}

	public String getKrasMutationStatus() {
		return krasMutationStatus;
	}

	public String getAlkTranslocationStatus() {
		return alkTranslocationStatus;
	}

	public String getAdjuvantTreatment() {
		return adjuvantTreatment;
	}

	public String getChemotherapy() {
		return chemotherapy;
	}

	public String getRadiation() {
		return radiation;
	}

	public String getRecurrence() {
		return recurrence;
	}

	public String getDateOfRecurrence() {
		return dateOfRecurrence;
	}

	public String getDateOfLastKnownAlive() {
		return dateOfLastKnownAlive;
	}

	public String getSurvivalStatus() {
		return survivalStatus;
	}

	public String getDateOfDeath() {
		return dateOfDeath;
	}

	public String getTimeToDeathDays() {
		return timeToDeathDays;
	}

	public String getCtDate() {
		return ctDate;
	}

	public String getDaysBetweenCtAndSurgery() {
		return daysBetweenCtAndSurgery;
	}


	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setPatientAffiliation(String patientAffiliation) {
		this.patientAffiliation = patientAffiliation;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setWeightLbs(String weightLbs) {
		this.weightLbs = weightLbs;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public void setSmokingStatus(String smokingStatus) {
		this.smokingStatus = smokingStatus;
	}

	public void setPackYears(String packYears) {
		this.packYears = packYears;
	}

	public void setQuitSmokingYear(String quitSmokingYear) {
		this.quitSmokingYear = quitSmokingYear;
	}

	public void setKrasMutationStatus(String krasMutationStatus) {
		this.krasMutationStatus = krasMutationStatus;
	}

	public void setAlkTranslocationStatus(String alkTranslocationStatus) {
		this.alkTranslocationStatus = alkTranslocationStatus;
	}

	public void setAdjuvantTreatment(String adjuvantTreatment) {
		this.adjuvantTreatment = adjuvantTreatment;
	}

	public void setChemotherapy(String chemotherapy) {
		this.chemotherapy = chemotherapy;
	}

	public void setRadiation(String radiation) {
		this.radiation = radiation;
	}

	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}

	public void setDateOfRecurrence(String dateOfRecurrence) {
		this.dateOfRecurrence = dateOfRecurrence;
	}

	public void setDateOfLastKnownAlive(String dateOfLastKnownAlive) {
		this.dateOfLastKnownAlive = dateOfLastKnownAlive;
	}

	public void setSurvivalStatus(String survivalStatus) {
		this.survivalStatus = survivalStatus;
	}

	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public void setTimeToDeathDays(String timeToDeathDays) {
		this.timeToDeathDays = timeToDeathDays;
	}

	public void setCtDate(String ctDate) {
		this.ctDate = ctDate;
	}

	public void setDaysBetweenCtAndSurgery(String daysBetweenCtAndSurgery) {
		this.daysBetweenCtAndSurgery = daysBetweenCtAndSurgery;
	}

    // getters and setters
}
