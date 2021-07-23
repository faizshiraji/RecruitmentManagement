package com.recruitmentmanagement.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.recruitmentmanagement.entities.JobCategory;
import com.recruitmentmanagement.service.JobCategoryService;

@Controller
public class HomeController {
	
	@Autowired
	private JobCategoryService jobCategoryService;
	
	@RequestMapping("/login")
	public String login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		
		return "redirect:/login";
		
	}
	
	@RequestMapping("/logout")
	public String logout() {
		
		return "login";
		
	}
	
	@GetMapping
	public String login(@RequestParam(value = "error", defaultValue = "false") boolean loginError) {
		if (loginError) {
			return "error-404";
			}
		return "login";
		
	}
	
	@RequestMapping("/admin/home")
	public String testController() {
		System.out.println("Main home");
		return "HEellooo";
		
	}
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String loginAdmin(Model model) {
		
		System.out.println("From Admin Controller");
		return "/admin/home";
	}
	
	
	@RequestMapping("/login/error")
	public String error() {
		return "error-404";
		
	}
	
	
	
	@RequestMapping("/admin/examPaper")
	public String examPaper() {
		
		return "/admin/examPage";
		
	}
	
	@RequestMapping("/admin/fragments")
    public String getFragments() {
        return "/admin/fragments.html";
    }
	
	
	@RequestMapping(value = "/admin/jobcat", method = RequestMethod.GET)
	public String jobcat(@ModelAttribute("jobCategory") JobCategory jobCategory, Model model) {

		long countJobCategory = jobCategoryService.countJobCategory();
		
		model.addAttribute("jobCategories", jobCategoryService.getJobCategories());
		model.addAttribute("countJobCategory", countJobCategory);
		return "/admin/jobcatPage";
		
	}
	
	
	
	@RequestMapping(value = "/admin/jobcatEdit/{id}", method = RequestMethod.GET)
	public String showJobCatUpdateForm(@PathVariable("id") Integer id, Model model) {

		JobCategory jobCategory = jobCategoryService.getJobCategory(id);
		
		model.addAttribute("jobCategoryEdit", jobCategory);

		System.out.println("Got it");
		
		return "/admin/jobcatPage";
		
	}
	
	
	@RequestMapping(value = "/admin/jobcatUpdate/{id}", method = RequestMethod.POST)
	public String updateJobCat(@PathVariable("id") Integer id, @Valid JobCategory jobCategory, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			jobCategory.setIdJobCategory(id);
			
			return "/admin/jobcatPage";
		}
		
		model.addAttribute("msg", "Job Category Updated");
		
		JobCategory jobCat = jobCategoryService.getJobCategory(id);
		
		jobCat.setCategoryName(jobCategory.getCategoryName());
		model.addAttribute("jobCategories", jobCategoryService.getJobCategories());
		jobCategoryService.updateJobCategory(jobCat);
		
		return "/admin/jobcatPage";
		
	}
	
	@RequestMapping(value = "/admin/jobcatDelete/{id}", method = RequestMethod.GET)
	public String deleteJobCat(@PathVariable("id") Integer id, @Valid JobCategory jobCategory, Model model) {
		
		jobCategoryService.deleteJobCategory(id);
		model.addAttribute("jobCategories", jobCategoryService.getJobCategories());
		model.addAttribute("msg", id + " No. Job Category Deleted");
		return "/admin/jobcatPage";
		
	}
	
	
	@RequestMapping("/admin/answerSheet")
	public String answerSheet() {
		return "/admin/answerPage";
		
	}
	
	@RequestMapping("/admin/myprofile")
	public String myProfile() {
		return "/admin/myprofile";
		
	}
	
	@PostMapping("/admin/addjobcat")
	public String addjobcat(@ModelAttribute("jobCategory") JobCategory jobCategory, Model model) {
		
		jobCategoryService.addJobCategory(jobCategory);
		model.addAttribute("jobCategories", jobCategoryService.getJobCategories());
		return "/admin/jobcatPage";
		
	}
	
	
}
