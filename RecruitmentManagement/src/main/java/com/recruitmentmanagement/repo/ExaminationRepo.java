package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.Examination;

@Repository
public interface ExaminationRepo extends JpaRepository<Examination, Integer> {

}
