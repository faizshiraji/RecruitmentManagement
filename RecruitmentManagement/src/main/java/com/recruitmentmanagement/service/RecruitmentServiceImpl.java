package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.Recruitment;
import com.recruitmentmanagement.repo.RecruitmentRepo;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

	@Autowired
	public RecruitmentRepo recruitmentRepo;
	
	@Override
	public List<Recruitment> getRecruitments() {
		return recruitmentRepo.findAll();
	}

	@Override
	public Recruitment getRecruitment(int idRecruitment) {
		return recruitmentRepo.findById(idRecruitment).get();
	}

	@Override
	public Recruitment addRecruitment(Recruitment recruitment) {
		return recruitmentRepo.save(recruitment);
	}

	@Override
	public Recruitment updateRecruitment(Recruitment recruitment) {
		return recruitmentRepo.save(recruitment);
	}

	@Override
	public void deleteRecruitment(int idRecruitment) {
		recruitmentRepo.deleteById(idRecruitment);
	}

	@Override
	public long countRecruitment() {
		return recruitmentRepo.count();
	}

}
