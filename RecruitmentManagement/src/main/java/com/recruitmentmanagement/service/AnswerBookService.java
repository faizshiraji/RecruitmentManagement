package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.AnswerBook;

public interface AnswerBookService {

	public List<AnswerBook> getAnswerBooks();
	
	public AnswerBook getAnswerBook(int idAnswerBook);
	
	public AnswerBook addAnswerBook(AnswerBook answerBook);
	
	public AnswerBook updateAnswerBook(AnswerBook answerBook);
	
	public void deleteAnswerBook(int idAnswerBook);
	
//	public AnswerBook getAnswerBookByQuestionBook(int idQuestionBook); 
}
