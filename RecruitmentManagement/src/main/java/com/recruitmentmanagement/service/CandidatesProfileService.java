package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.CandidatesProfile;

public interface CandidatesProfileService {

	public List<CandidatesProfile> getCandidatesProfiles();
	
	public CandidatesProfile getCandidatesProfile(int idCandidateProfile);
	
	public CandidatesProfile addCandidatesProfile(CandidatesProfile candidatesProfile);
	
	public CandidatesProfile updateCandidatesProfile(CandidatesProfile candidatesProfile);
	
	public void deleteCandidateProfile(int idCandidateProfile);
	
	public long countCandidateProfile();
	
}
