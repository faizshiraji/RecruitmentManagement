package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.QuestionBook;

public interface QuestionBookService {

	public List<QuestionBook> getQuestionBooks();
	
	public QuestionBook getQuestionBook(int idQuestionBook);
	
	public QuestionBook addQuestionBook(QuestionBook questionBook);
	
	public QuestionBook updateQuestionBook(QuestionBook questionBook);
	
	public void deleteQuestionBook(int idQuestionBook);
	
}
