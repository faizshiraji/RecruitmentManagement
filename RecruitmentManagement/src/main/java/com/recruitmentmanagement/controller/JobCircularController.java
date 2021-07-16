package com.recruitmentmanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("/jobdetails/{id}")
	public String viewJobCircularDetailsInPbl(@PathVariable("id") Integer id, Model model) {
		
		JobCircular jobCircular = jobCircularService.getJobCircular(id);
		
		System.out.println(jobCircular);
		model.addAttribute("jobCircular", jobCircular);
		
		return "jobdetails";
	}
	
	@RequestMapping("/admin/jobcircular")
	public String jobcircular(JobCircular jobCircular, Model model) {
		
		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		List<JobCircular> jobCirculars = jobCircularService.getJobCirculars();
		model.addAttribute("jobCategories", jobCategories);
		model.addAttribute("jobCirculars", jobCirculars);
		
		return "/admin/jobcircularPage";
		
	}
	
	@RequestMapping(value = "/admin/addJobCircular", method = RequestMethod.POST)
	public String addJobCircular(JobCircular jobCircular, Model model) {

		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		List<JobCircular> jobCirculars = jobCircularService.getJobCirculars();
		
//		jobCircular.setPublishDate(new Date());
		jobCircular.setStatus("Draft");
		
		jobCircularService.addJobCircular(jobCircular);
		model.addAttribute("jobCirculars", jobCirculars);
		model.addAttribute("jobCategories", jobCategories);
		System.out.println("JobCircular Added Successfully");
		
		return "/admin/jobcircularPage";
	}
	

	@GetMapping("/admin/jobcirculardetail/{id}")
	public String viewJobCircularDetailsInPvt(@PathVariable("id") Integer id, Model model) {
		
		JobCircular jobCircular = jobCircularService.getJobCircular(id);
		
		System.out.println(jobCircular);
		model.addAttribute("jobCircular", jobCircular);
		
		return "/admin/viewjobcircularPage";
	}
	
	@GetMapping("/admin/jobcircularDelete/{id}")
	public String deleteJobCircular(@PathVariable("id") Integer id, Model model) {
		jobCircularService.deleteJobCircular(id);
		
		String msg = "Selected Job Circular Removed successfully.";
		
		model.addAttribute("", msg);
		
		return "/admin/jobcircularPage";
	}
	
	@GetMapping("/admin/jobcircularEdit/{id}")
	public String editJobCircular(@PathVariable("id") Integer id, Model model) {
		
		jobCircularService.getJobCircular(id);
		
		
		return "/admin/jobcircularPage";
	}
	
	@GetMapping("/admin/jobcircularPublish/{id}")
	public String publishJobCircular(@PathVariable("id") Integer id, Model model) {
		JobCircular jobCircular = jobCircularService.getJobCircular(id);
		jobCircular.setStatus("publish");
		jobCircular.setPublishDate(new Date());
		jobCircularService.updateJobCircular(jobCircular);
		
		model.addAttribute("jobCircular", jobCircular);
		
		return "/admin/viewjobcircularPage";
		
	}
}
