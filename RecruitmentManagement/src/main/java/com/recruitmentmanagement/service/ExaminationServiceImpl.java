package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.Examination;
import com.recruitmentmanagement.repo.ExaminationRepo;

@Service
public class ExaminationServiceImpl implements ExaminationService {

	@Autowired
	public ExaminationRepo examinationRepo;
	
	@Override
	public List<Examination> getExaminations() {
		return examinationRepo.findAll();
	}

	@Override
	public Examination getExamination(int idExamination) {
		return examinationRepo.findById(idExamination).get();
	}

	@Override
	public Examination addExamination(Examination examination) {
		return examinationRepo.save(examination);
	}

	@Override
	public Examination updateExamination(Examination examination) {
		return examinationRepo.save(examination);
	}

	@Override
	public void deleteExamination(int idExamination) {
		examinationRepo.deleteById(idExamination);
	}

	@Override
	public long countExamination() {
		return examinationRepo.count();
	}

}
