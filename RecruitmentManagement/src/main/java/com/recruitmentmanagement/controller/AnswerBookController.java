package com.recruitmentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.recruitmentmanagement.entities.AnswerBook;
import com.recruitmentmanagement.entities.QuestionBook;
import com.recruitmentmanagement.service.AnswerBookService;
import com.recruitmentmanagement.service.JobCategoryService;
import com.recruitmentmanagement.service.QuestionBookService;

@Controller
public class AnswerBookController {

	@Autowired
	private QuestionBookService questionBookService;
	
	@Autowired
	private AnswerBookService answerBookService;
	
	@Autowired
	private JobCategoryService jobCategoryService;
	
	@PostMapping("/admin/addAnswerBook/{id}")
	public String addAnswerBook(@PathVariable("id") Integer id, @ModelAttribute("answerBook") AnswerBook answerBook, Model model) {
		
		QuestionBook questionBook = questionBookService.getQuestionBook(id);
		
		questionBook.getAnswerBook().add(answerBook);
		
		questionBookService.updateQuestionBook(questionBook);
		
		QuestionBook getQuestionBook = questionBookService.getQuestionBook(id);
		List<AnswerBook> questionAnswers = getQuestionBook.getAnswerBook();
		model.addAttribute("question", getQuestionBook);
		model.addAttribute("questionAnswers", questionAnswers);
		model.addAttribute("msg", "Answer added in this question.");
		
		System.out.println(answerBook.toString());
		
		return "/admin/answerPage";
		
	}
	
	@GetMapping("/admin/setAnswerForQuestionBook/{qid}/{id}")
	public String setAnswerForQuestionBook(@PathVariable("qid") Integer qid, @PathVariable("id") Integer id, @ModelAttribute("answerBook") AnswerBook answerBook, Model model) {
		
		QuestionBook getQuestionBook = questionBookService.getQuestionBook(qid);
		List<AnswerBook> questionAnswers = getQuestionBook.getAnswerBook();
		
		AnswerBook correctAnswerBook = answerBookService.getAnswerBook(id);
		
		if (correctAnswerBook.isCorrectAnswer() == true) {
			correctAnswerBook.setCorrectAnswer(false);
		}else {
			correctAnswerBook.setCorrectAnswer(true);
		}
		
		answerBookService.updateAnswerBook(correctAnswerBook);
		
		model.addAttribute("question", getQuestionBook);
		model.addAttribute("questionAnswers", questionAnswers);
		
		
		return "/admin/answerPage";
		
	}
	
}
