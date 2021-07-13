package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.AnswerBook;

@Repository
public interface AnswerBookRepo extends JpaRepository<AnswerBook, Integer> {

//	AnswerBook findbyQuestionBook(int idQuestionBook);
	
}
