package com.coforge.job.model.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coforge.job.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {
	
	
//    private int jobId;
//	private String companyName;
//	private String profile;
//	private String skillRequired;
//	private double experience;
	
	
  	List<Job> findByProfile(String profile);
  	
	List<Job> findByCompanyNameAndProfile(String cName,String profile);
	
	List<Job> deleteByJobId(int id);

	

}
