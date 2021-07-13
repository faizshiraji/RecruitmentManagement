package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.QuestionBook;
import com.recruitmentmanagement.repo.QuestionBookRepo;

@Service
public class QuestionBookServiceImpl implements QuestionBookService {

	@Autowired
	public QuestionBookRepo questionBookRepo;
	
	@Override
	public List<QuestionBook> getQuestionBooks() {
		return questionBookRepo.findAll();
	}

	@Override
	public QuestionBook getQuestionBook(int idQuestionBook) {
		return questionBookRepo.findById(idQuestionBook).get();
	}

	@Override
	public QuestionBook addQuestionBook(QuestionBook questionBook) {
		return questionBookRepo.save(questionBook);
	}

	@Override
	public QuestionBook updateQuestionBook(QuestionBook questionBook) {
		return questionBookRepo.save(questionBook);
	}

	@Override
	public void deleteQuestionBook(int idQuestionBook) {
		questionBookRepo.deleteById(idQuestionBook);
	}

}
