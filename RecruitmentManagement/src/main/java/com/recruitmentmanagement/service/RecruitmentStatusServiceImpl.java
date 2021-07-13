package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.RecruitmentStatus;
import com.recruitmentmanagement.repo.RecruitmentStatusRepo;

@Service
public class RecruitmentStatusServiceImpl implements RecruitmentStatusService {

	@Autowired
	public RecruitmentStatusRepo recruitmentStatusRepo;
	
	@Override
	public List<RecruitmentStatus> getRecruitmentStatus() {

		return recruitmentStatusRepo.findAll();
	}

	@Override
	public RecruitmentStatus getRecruitmentStatus(int idRecruitmentStatus) {
		return recruitmentStatusRepo.findById(idRecruitmentStatus).get();
	}

	@Override
	public RecruitmentStatus addRecruitmentStatus(RecruitmentStatus recruitmentStatus) {
		return recruitmentStatusRepo.save(recruitmentStatus);
	}

	@Override
	public RecruitmentStatus updateRecruitmentStatus(RecruitmentStatus recruitmentStatus) {
		return recruitmentStatusRepo.save(recruitmentStatus);
	}

	@Override
	public void deleteRecruitmentStatus(int idRecruitmentStatus) {
		recruitmentStatusRepo.deleteById(idRecruitmentStatus);
	}

	@Override
	public long countRecruitmentStatus() {
		return recruitmentStatusRepo.count();
	}

}
