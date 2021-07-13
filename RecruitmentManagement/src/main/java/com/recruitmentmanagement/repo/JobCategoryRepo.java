package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.JobCategory;

@Repository
public interface JobCategoryRepo extends JpaRepository<JobCategory, Integer> {

}
