package com.coforge.job.model.service;

import java.util.List;

import com.coforge.job.model.Job;


public interface JobService {

	public List<Job> getAllJobs();
	
	public Job saveJobDetails(Job job);
	
  	public List<Job> findByProfile(String profile);
  	
	public List<Job> findByCompanyNameAndProfile(String cName,String profile);

	public List<Job> deleteByJobId(int id);
	
	public Job updateJob(Job job);
	
	
}
