package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.Recruitment;

public interface RecruitmentService {

	public List<Recruitment> getRecruitments();
	
	public Recruitment getRecruitment(int idRecruitment);
	
	public Recruitment addRecruitment(Recruitment recruitment);
	
	public Recruitment updateRecruitment(Recruitment recruitment);
	
	public void deleteRecruitment(int idRecruitment);
	
	public long countRecruitment();
	
}
