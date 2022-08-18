package com.coforge.favourite.job.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.favourite.job.model.AddFavouriteJob;

public interface AddFavouriteJobRepo extends JpaRepository<AddFavouriteJob, Integer> {

	//Query Method
    // private int jobId;
	List<AddFavouriteJob> findByJobId(int jobId);

}
