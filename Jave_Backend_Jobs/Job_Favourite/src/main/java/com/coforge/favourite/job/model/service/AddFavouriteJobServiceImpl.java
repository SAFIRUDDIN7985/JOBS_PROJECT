package com.coforge.favourite.job.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.favourite.job.model.AddFavouriteJob;
import com.coforge.favourite.job.model.repo.AddFavouriteJobRepo;


@Service
public class AddFavouriteJobServiceImpl implements AddFavouriteJobService {

	@Autowired
	private AddFavouriteJobRepo addFavouriteJobRepo;
	
	@Override
	public AddFavouriteJob saveFavouriteJobs(AddFavouriteJob fJob) {
		
		return addFavouriteJobRepo.save(fJob) ;
	}

	
	@Override
	public List<AddFavouriteJob> findByJobId(int jobId) {
		return addFavouriteJobRepo.findByJobId(jobId);
	}


	@Override
	public List<AddFavouriteJob> getAllTheFavouriteJobs() {
		
		return addFavouriteJobRepo.findAll();
	}


	@Override
	public AddFavouriteJob deleteFavouriteJobId(int id) {
		
		AddFavouriteJob addFavouriteJob=null;
		Optional findById = addFavouriteJobRepo.findById(id);
		if(findById.isPresent()) {
			addFavouriteJob = addFavouriteJobRepo.findById(id).get();
			addFavouriteJobRepo.deleteById(id);
		}

		return addFavouriteJob;
		

		
		
	}

}

//@Override
//public Blog deleteBlog(int blogId) {
//	Blog blog = null;
//	Optional result = blogRepository.findById(blogId);
//	if (result.isPresent()) {
//		blog = blogRepository.findById(blogId).get();
//		blogRepository.deleteById(blogId);
//	}
//	return blog;
//}
