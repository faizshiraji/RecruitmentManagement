package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.QuestionBook;

@Repository
public interface QuestionBookRepo extends JpaRepository<QuestionBook, Integer> {

}
