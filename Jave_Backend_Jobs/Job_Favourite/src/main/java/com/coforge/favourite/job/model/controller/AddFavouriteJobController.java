package com.coforge.favourite.job.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.favourite.job.model.AddFavouriteJob;
import com.coforge.favourite.job.model.service.AddFavouriteJobService;

@RestController
@RequestMapping(path="addFavouriteJob")
@CrossOrigin(origins = "http://localhost:4200")
public class AddFavouriteJobController {
	
	@Autowired
	private AddFavouriteJobService addFavouriteJobService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="save")
	public ResponseEntity<?> saveAllFavouriteJobs(@RequestBody AddFavouriteJob addFavouriteJob ){
		System.out.println(addFavouriteJob.getCompanyName());
		System.out.println(addFavouriteJob.getProfile());
		System.out.println(addFavouriteJob.getProfile());
		System.out.println(addFavouriteJob.getId());
//		return new ResponseEntity<>(addFavouriteJobService.saveFavouriteJobs(addFavouriteJob),HttpStatus.FOUND);
		return ResponseEntity.ok(addFavouriteJobService.saveFavouriteJobs(addFavouriteJob));

		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="find/{jobId}")
	public ResponseEntity<?> findFavouriteJobByJobId(@PathVariable("jobId") int jobId){
		return new ResponseEntity<>(addFavouriteJobService.findByJobId(jobId),HttpStatus.FOUND);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="findAllJob")
	public ResponseEntity<?> findAllTheFavouriteJobs(){
		 List<AddFavouriteJob> allTheFavouriteJobs = addFavouriteJobService.getAllTheFavouriteJobs();
//		for (AddFavouriteJob addFavouriteJob : allTheFavouriteJobs) {
//			System.out.println(addFavouriteJob.getCompanyName());
//			System.out.println(addFavouriteJob.getExperience());
//		}
		 return ResponseEntity.ok(allTheFavouriteJobs);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path="deleteFavourite/{id}")
	public ResponseEntity<?> deleteFavouriteJobs(@PathVariable("id") int id){
		System.out.println("safiruddin khan");
		System.out.println(id);
		return new ResponseEntity<>(addFavouriteJobService.deleteFavouriteJobId(id),HttpStatus.OK);
	}

}
