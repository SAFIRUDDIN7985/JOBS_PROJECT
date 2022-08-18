package com.coforge.job.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.job.model.Job;
import com.coforge.job.model.repo.JobRepo;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepo jobRepo;
	
	@Override
	public Job saveJobDetails(Job job) {
		return jobRepo.save(job);
	}


	@Override
	public List<Job> findByProfile(String profile) {
		return jobRepo.findByProfile(profile);
	}

	@Override
	public List<Job> findByCompanyNameAndProfile(String cName, String profile) {
		return jobRepo.findByCompanyNameAndProfile(cName, profile);
	}

	@Transactional
	@Override
	public List<Job> deleteByJobId(int id) {
		
		List<Job> deleteByJobId = jobRepo.deleteByJobId(id);
		return deleteByJobId;
	}

	@Override
	public Job updateJob(Job job) {
		
		Job job1=null;
		Optional<Job> findById = jobRepo.findById(job.getJobId());
		if(findById.isPresent()) {
			Job job2 = jobRepo.findById(job.getJobId()).get();
			job2.setProfile(job.getProfile());
			job2.setCompanyName(job.getCompanyName());
			job2.setSkillRequired(job.getSkillRequired());
			job2.setExperience(job.getExperience());
			job1=saveJobDetails(job2);
		}
		return job1;
	}


	@Override
	public List<Job> getAllJobs() {
		return jobRepo.findAll();
	}


	
	
	

	
	

}
