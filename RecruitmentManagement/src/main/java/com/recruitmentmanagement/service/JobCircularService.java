package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.JobCircular;

public interface JobCircularService {

	public List<JobCircular> getJobCirculars();
	
	public JobCircular getJobCircular(int idJobCircular);

	public JobCircular addJobCircular(JobCircular jobCircular);
	
	public JobCircular updateJobCircular(JobCircular jobCircular);
	
	public void deleteJobCircular(int idJobCircular);
	
	public long countJobCircular();
}
