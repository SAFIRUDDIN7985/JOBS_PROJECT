package com.coforge.job.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coforge.job.model.AddFavoriteJob;
import com.coforge.job.model.Job;
import com.coforge.job.model.service.JobService;

@RestController
@RequestMapping(path="job")
@CrossOrigin(origins = "http://localhost:4200")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@PostMapping(path="save")
//	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> saveAllJobDetails(@RequestBody Job job){
		System.out.println(job.getJobId());
		System.out.println(job.getCompanyName());
		System.out.println(job.getProfile());
		System.out.println(job.getExperience());
		System.out.println(job.getSkillRequired());
		return new ResponseEntity<>(jobService.saveJobDetails(job),HttpStatus.ACCEPTED);
//		return ResponseEntity.ok(job);
	}
	
	@GetMapping(path="/jobLists")
//	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> getAllJobs(){
		List<Job> allJobs = ((JobService) jobService).getAllJobs();
		
//		if(null!=allJobs) {
//			for (Job job : allJobs) {
//				System.out.println(job.getCompanyName());
//				System.out.println(job.getSkillRequired());
//				
//			}
//		}

		return ResponseEntity.ok(allJobs);
		
//		return new ResponseEntity<>(allJobs,HttpStatus.FOUND);

		
	}
	
	@GetMapping(path="find/{profile}")

	public ResponseEntity<?> getJobByProfile(@PathVariable("profile") String profile){
		return new ResponseEntity<>(jobService.findByProfile(profile),HttpStatus.FOUND);
	}
	

	
	@GetMapping(path="find/{cName}/{cProgile}")
	public ResponseEntity<?> getJobByCompanyNameAndProfile(@PathVariable("cName") String cName,@PathVariable("cProgile") String cProgile){
		return new ResponseEntity<>(jobService.findByCompanyNameAndProfile(cName, cProgile),HttpStatus.FOUND);
	}
	
	
	@PutMapping(path="update")
	public ResponseEntity<?> updateJobByJobId(@RequestBody Job job){
		return new ResponseEntity<>(jobService.updateJob(job),HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping(path="delete/{id}")
//	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> deleteJobByIds(@PathVariable("id") int id){
		return new ResponseEntity<>(((JobService) jobService).deleteByJobId(id),HttpStatus.ACCEPTED);
	}

	@GetMapping(path="/{id}")
//	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> getAddFavouriteJobByJobId(@PathVariable("id") int id){
		String url="http://localhost:8001/addFavouriteJob/find/"+id;
		AddFavoriteJob[] forObject = restTemplate.getForObject(url, AddFavoriteJob[].class);
		
		for (AddFavoriteJob addFavoriteJob : forObject) {
			System.out.println(addFavoriteJob.getId());
			System.out.println(addFavoriteJob.getCompanyName());
			System.out.println(addFavoriteJob.getProfile());
			System.out.println(addFavoriteJob.getSkillRequired());
			System.out.println(addFavoriteJob.getJobId());
			
		}
		
		return new ResponseEntity<>(forObject,HttpStatus.OK);
		
	}
	
	@DeleteMapping("deleteF/{id}")
	public void deleteFavouriteJobById(@PathVariable("id") int id){
		String url="http://localhost:8001/addFavouriteJob/deleteFavourite/"+id;
		System.out.println("safir");
		System.out.println("safiruddin");
	      restTemplate.delete(url);

	}
}
