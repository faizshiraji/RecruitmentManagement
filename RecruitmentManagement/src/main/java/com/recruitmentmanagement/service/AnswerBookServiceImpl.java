package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.AnswerBook;
import com.recruitmentmanagement.repo.AnswerBookRepo;

@Service
public class AnswerBookServiceImpl implements AnswerBookService {

	@Autowired
	public AnswerBookRepo answerBookRepo;
	
	@Override
	public List<AnswerBook> getAnswerBooks() {
		return answerBookRepo.findAll();
	}

	@Override
	public AnswerBook getAnswerBook(int idAnswerBook) {
		return answerBookRepo.findById(idAnswerBook).get();
	}

	@Override
	public AnswerBook addAnswerBook(AnswerBook answerBook) {
		return answerBookRepo.save(answerBook);
	}

	@Override
	public AnswerBook updateAnswerBook(AnswerBook answerBook) {
		return answerBookRepo.save(answerBook);
	}

	@Override
	public void deleteAnswerBook(int idAnswerBook) {
		answerBookRepo.deleteById(idAnswerBook);
	}

//	@Override
//	public AnswerBook getAnswerBookByQuestionBook(int idQuestionBook) {
//		return answerBookRepo.findbyQuestionBook(idQuestionBook);
//	}

}
