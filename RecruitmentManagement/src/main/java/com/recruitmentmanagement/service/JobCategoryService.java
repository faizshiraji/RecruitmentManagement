package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.JobCategory;

public interface JobCategoryService {

	public List<JobCategory> getJobCategories();
	
	public JobCategory getJobCategory(int idJobCategory);

	public JobCategory addJobCategory(JobCategory jobCategory);
	
	public JobCategory updateJobCategory(JobCategory jobCategory);
	
	public void deleteJobCategory(int idJobCategory);
	
	public long countJobCategory();
	
}
