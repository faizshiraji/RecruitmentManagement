package com.recruitmentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.recruitmentmanagement.entities.Users;
import com.recruitmentmanagement.service.UserRoleService;
import com.recruitmentmanagement.service.UsersService;

@Controller
public class CandidatesController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("/users/index")
	public String loginUser(Model model) {
		
		model.addAttribute("buttonActive", "index");
		return "/users/index";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		
		System.out.println("Registration stage");
		
		model.addAttribute("users", new Users());
		
		return "register";
	}
	
	@RequestMapping(value = "/process_registration", method = RequestMethod.POST)
	public String processRegister(Users users, BindingResult result, ModelMap modelMap, Model model) {
		
		if (result.hasErrors()) {
			System.out.println("Getting Error!!!!");
			return "register";
			
		}
				
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(users.getPassword());
		users.setPassword(encodePassword);
		users.setUserRole(userRoleService.getUserRole(2));
		usersService.addUsers(users);
		String msg = "Registration Successful.";
		modelMap.addAttribute("msg", msg);
		
		System.out.println("Test Process Registration!!!!");
		
		return "login";
		
	}
	
	@RequestMapping("/users/userProfile")
	public String userProfile(Model model) {
		model.addAttribute("buttonActive", "userProfile");
		return "/users/userprofile";
		
	}
	
	@RequestMapping("/users/editprofile")
	public String editUserProfile(Model model) {
		model.addAttribute("buttonActive", "userProfile");
		return "/users/edituserprofile";
		
	}
	
	@RequestMapping("/users/jobcircularApplied")
	public String jobcircularApplied(Model model) {
		model.addAttribute("buttonActive", "jobcircularApplied");
		return "/users/jobcircular_applied";
		
	}
	
	@RequestMapping("/users/usersExams")
	public String usersExams(Model model) {
		model.addAttribute("buttonActive", "jobcircularApplied");
		return "/users/users_exams";
		
	}
	
	@RequestMapping("/users/usersScoreCard")
	public String usersScoreCard(Model model) {
		model.addAttribute("buttonActive", "jobcircularApplied");
		return "/users/users_scorecard";
		
	}
}
