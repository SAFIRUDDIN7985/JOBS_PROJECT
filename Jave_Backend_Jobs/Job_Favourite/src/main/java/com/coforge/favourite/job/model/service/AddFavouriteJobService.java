package com.coforge.favourite.job.model.service;

import java.util.List;

import com.coforge.favourite.job.model.AddFavouriteJob;

public interface AddFavouriteJobService {
	
	
	AddFavouriteJob saveFavouriteJobs(AddFavouriteJob fJob);
	
	List<AddFavouriteJob> getAllTheFavouriteJobs();
	
	List<AddFavouriteJob> findByJobId(int jobId);
	
	AddFavouriteJob deleteFavouriteJobId(int id);

}
