package com.recruitmentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.recruitmentmanagement.entities.JobCategory;
import com.recruitmentmanagement.entities.JobCircular;
import com.recruitmentmanagement.service.JobCategoryService;
import com.recruitmentmanagement.service.JobCircularService;

@Controller
public class JobCircularController {

	@Autowired
	private JobCategoryService jobCategoryService;
	
	@Autowired
	private JobCircularService jobCircularService;
	
	@RequestMapping("/admin/jobcircular")
	public String jobcircular(JobCircular jobCircular, Model model) {
		
		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		
		model.addAttribute("jobCategories", jobCategories);
		
		return "/admin/jobcircularPage";
		
	}
	
	@RequestMapping("/jobdetails")
	public String jobDetails() {
		
		return "jobdetails";
		
	}
	
	@RequestMapping(value = "/admin/addJobCircular", method = RequestMethod.POST)
	public String addJobCircular(JobCircular jobCircular, Model model) {

		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		
		jobCircularService.addJobCircular(jobCircular);
		model.addAttribute("jobCategories", jobCategories);
		System.out.println("JobCircular Added Successfully");
		
		return "/admin/jobcircularPage";
	}
	
}
