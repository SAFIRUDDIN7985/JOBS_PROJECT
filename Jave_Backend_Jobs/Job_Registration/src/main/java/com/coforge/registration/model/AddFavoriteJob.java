package com.coforge.registration.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AddFavoriteJob {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String companyName;
	private String profile;
	private String skillRequired;
	private double experience;
	
	private int jobId;

	public AddFavoriteJob() {
		super();
	}

	public AddFavoriteJob(int id, String companyName, String profile, String skillRequired, double experience,
			int jobId) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.profile = profile;
		this.skillRequired = skillRequired;
		this.experience = experience;
		this.jobId = jobId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getSkillRequired() {
		return skillRequired;
	}

	public void setSkillRequired(String skillRequired) {
		this.skillRequired = skillRequired;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	
	
	
	
	
}
