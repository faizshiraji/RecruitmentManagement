package com.recruitmentmanagement.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recruitmentmanagement.entities.AnswerBook;
import com.recruitmentmanagement.entities.JobCategory;
import com.recruitmentmanagement.entities.QuestionBook;
import com.recruitmentmanagement.entities.custom.QuestionBookForm;
import com.recruitmentmanagement.service.AnswerBookService;
import com.recruitmentmanagement.service.JobCategoryService;
import com.recruitmentmanagement.service.QuestionBookService;

@Controller
public class QuestionBookController {

	@Autowired
	private QuestionBookService questionBookService;
	
	@Autowired
	private AnswerBookService answerBookService;

	@Autowired
	private JobCategoryService jobCategoryService;

	@RequestMapping("/admin/questionPaper")
	public String questionPaper(QuestionBook questionBook, Model model) {

		List<QuestionBook> questionBooks = questionBookService.getQuestionBooks();
		

		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		
		
		model.addAttribute("questionBooks", questionBooks);
		model.addAttribute("jobCategories", jobCategories);

		return "/admin/questionPage";
	}

	@PostMapping("/admin/addQuestion")
	public String addQuestion(@ModelAttribute("questionBook") QuestionBook questionBook, Model model) {

		questionBookService.addQuestionBook(questionBook);
		
		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		List<QuestionBook> questionBooks = questionBookService.getQuestionBooks();

		model.addAttribute("questionBooks", questionBooks);
		model.addAttribute("jobCategories", jobCategories);
		
		return "/admin/questionPage";

	}
	
	@GetMapping("/admin/questionBookEdit/{id}")
	public String goQuestionEditPage(@PathVariable("id") Integer id, Model model) {
		
		QuestionBook questionBook = questionBookService.getQuestionBook(id);
		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		List<QuestionBook> questionBooks = questionBookService.getQuestionBooks();
		model.addAttribute("questionBookEdit", questionBook);
		model.addAttribute("questionBooks", questionBooks);
		model.addAttribute("jobCategories", jobCategories);
		return "/admin/questionPage";
		
	}
	
	@PostMapping("/admin/updateQuestion/{id}")
	public String updateQuestion(@PathVariable("id") Integer id, @Valid QuestionBook questionBook, BindingResult result, Model model) {
		
		if (result.hasErrors()) {

			return "/admin/questionPage";
		}

		model.addAttribute("msg", "Question Book Updated");
		
		QuestionBook questionBook2 = questionBookService.getQuestionBook(id);
		
		questionBook2.setJobCategory(questionBook.getJobCategory());
		questionBook2.setOption(questionBook.getOption());
		questionBook2.setQuestion(questionBook.getQuestion());
		
		questionBookService.updateQuestionBook(questionBook2);
		
		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		List<QuestionBook> questionBooks = questionBookService.getQuestionBooks();
		model.addAttribute("questionBooks", questionBooks);
		model.addAttribute("jobCategories", jobCategories);
		
		return "/admin/questionPage";
		
	}
	
	@GetMapping("/admin/questionBookDelete/{id}")
	public String deleteQuestion(@PathVariable("id") Integer id, @Valid QuestionBook questionBook, Model model) {
		
		questionBookService.deleteQuestionBook(id);
		List<JobCategory> jobCategories = jobCategoryService.getJobCategories();
		List<QuestionBook> questionBooks = questionBookService.getQuestionBooks();
		model.addAttribute("questionBooks", questionBooks);
		model.addAttribute("jobCategories", jobCategories);

		model.addAttribute("msg", id + " No. Question Book Deleted.");

		
		return "/admin/questionPage";
		
	}
	
	@GetMapping("/admin/questionBookAnswer/{id}")
	public String setAnswer(@PathVariable("id") Integer id, @Valid QuestionBook questionBook, Model model) {
		
		QuestionBook getQuestionBook = questionBookService.getQuestionBook(id);
		List<AnswerBook> questionAnswers = getQuestionBook.getAnswerBook();
		AnswerBook answerBook = new AnswerBook();
		System.out.println(answerBook.toString());
		
		model.addAttribute("question", getQuestionBook);
		model.addAttribute("answerBook", answerBook);
		model.addAttribute("questionAnswers", questionAnswers);
		
		return "/admin/answerPage";
		
	}
	
}
