package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.JobCircular;
import com.recruitmentmanagement.repo.JobCircularRepo;
@Service
public class JobCircularServiceImpl implements JobCircularService {

	@Autowired
	public JobCircularRepo jobCircularRepo;
	
	@Override
	public List<JobCircular> getJobCirculars() {
		return jobCircularRepo.findAll();
	}

	@Override
	public JobCircular getJobCircular(int idJobCircular) {
		return jobCircularRepo.findById(idJobCircular).get();
	}

	@Override
	public JobCircular addJobCircular(JobCircular jobCircular) {
		return jobCircularRepo.save(jobCircular);
	}

	@Override
	public JobCircular updateJobCircular(JobCircular jobCircular) {
		return jobCircularRepo.save(jobCircular);
	}

	@Override
	public void deleteJobCircular(int idJobCircular) {
		jobCircularRepo.deleteById(idJobCircular);
	}

	@Override
	public long countJobCircular() {
		return jobCircularRepo.count();
	}

}
