package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.Examination;

public interface ExaminationService {

	public List<Examination> getExaminations();
	
	public Examination getExamination(int idExamination);
	
	public Examination addExamination(Examination examination);
	
	public Examination updateExamination(Examination examination);
	
	public void deleteExamination(int idExamination);
	
	public long countExamination();
	
}
