package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.Recruitment;

@Repository
public interface RecruitmentRepo extends JpaRepository<Recruitment, Integer> {

}
