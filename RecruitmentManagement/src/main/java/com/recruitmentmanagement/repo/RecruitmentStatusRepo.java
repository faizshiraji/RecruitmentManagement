package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.RecruitmentStatus;

@Repository
public interface RecruitmentStatusRepo extends JpaRepository<RecruitmentStatus, Integer> {

}
