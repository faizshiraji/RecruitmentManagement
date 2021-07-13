package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.CandidatesProfile;
import com.recruitmentmanagement.repo.CandidatesProfileRepo;

@Service
public class CandidatesProfileServiceImpl implements CandidatesProfileService {

	@Autowired
	public CandidatesProfileRepo candidatesProfileRepo;
	
	@Override
	public List<CandidatesProfile> getCandidatesProfiles() {
		return candidatesProfileRepo.findAll();
	}

	@Override
	public CandidatesProfile getCandidatesProfile(int idCandidateProfile) {
		return candidatesProfileRepo.findById(idCandidateProfile).get();
	}

	@Override
	public CandidatesProfile addCandidatesProfile(CandidatesProfile candidatesProfile) {
		return candidatesProfileRepo.save(candidatesProfile);
	}

	@Override
	public CandidatesProfile updateCandidatesProfile(CandidatesProfile candidatesProfile) {
		return candidatesProfileRepo.save(candidatesProfile);
	}

	@Override
	public void deleteCandidateProfile(int idCandidateProfile) {
		candidatesProfileRepo.deleteById(idCandidateProfile);
	}

	@Override
	public long countCandidateProfile() {
		return candidatesProfileRepo.count();
	}

}
