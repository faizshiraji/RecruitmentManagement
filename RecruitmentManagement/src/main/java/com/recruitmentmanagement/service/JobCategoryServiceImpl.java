package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.JobCategory;
import com.recruitmentmanagement.repo.JobCategoryRepo;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

	@Autowired
	public JobCategoryRepo jobCategoryRepo;
	
	@Override
	public List<JobCategory> getJobCategories() {
		return jobCategoryRepo.findAll();
	}

	@Override
	public JobCategory getJobCategory(int idJobCategory) {
		return jobCategoryRepo.findById(idJobCategory).get();
	}

	@Override
	public JobCategory addJobCategory(JobCategory jobCategory) {
		return jobCategoryRepo.save(jobCategory);
	}

	@Override
	public JobCategory updateJobCategory(JobCategory jobCategory) {
		return jobCategoryRepo.save(jobCategory);
	}

	@Override
	public void deleteJobCategory(int idJobCategory) {
		jobCategoryRepo.deleteById(idJobCategory);
	}

	@Override
	public long countJobCategory() {
		return jobCategoryRepo.count();
	}

}
