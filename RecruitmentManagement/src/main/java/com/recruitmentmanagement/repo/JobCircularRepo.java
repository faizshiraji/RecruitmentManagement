package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.JobCircular;

@Repository
public interface JobCircularRepo extends JpaRepository<JobCircular, Integer> {

}
