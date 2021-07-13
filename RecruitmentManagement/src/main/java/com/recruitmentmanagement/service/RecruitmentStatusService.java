package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.RecruitmentStatus;

public interface RecruitmentStatusService {

	public List<RecruitmentStatus> getRecruitmentStatus();
	
	public RecruitmentStatus getRecruitmentStatus(int idRecruitmentStatus);
	
	public RecruitmentStatus addRecruitmentStatus(RecruitmentStatus recruitmentStatus);
	
	public RecruitmentStatus updateRecruitmentStatus(RecruitmentStatus recruitmentStatus);
	
	public void deleteRecruitmentStatus(int idRecruitmentStatus);
	
	public long countRecruitmentStatus();
	
}
