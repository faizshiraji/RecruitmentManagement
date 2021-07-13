package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.CandidatesProfile;

@Repository
public interface CandidatesProfileRepo extends JpaRepository<CandidatesProfile, Integer> {

}
