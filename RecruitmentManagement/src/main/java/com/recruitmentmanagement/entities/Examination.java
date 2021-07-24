package com.recruitmentmanagement.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "examination")
public class Examination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExamination;
	private String refExamination;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_id")
	private CandidatesProfile candidatesProfile;
	private int examMark;
	private int resultMark;
	private String examUrl;
	private int status;
	private Time examTotalTime;
	private Time examTime;
	private Date examDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "examination_id")
	List<QuestionBook> questionBook = new ArrayList<>();

	public Examination() {
	}

	public Examination(String refExamination, CandidatesProfile candidatesProfile, int examMark, int resultMark,
			String examUrl, int status, Time examTotalTime, Time examTime, Date examDate,
			List<QuestionBook> questionBook) {
		this.refExamination = refExamination;
		this.candidatesProfile = candidatesProfile;
		this.examMark = examMark;
		this.resultMark = resultMark;
		this.examUrl = examUrl;
		this.status = status;
		this.examTotalTime = examTotalTime;
		this.examTime = examTime;
		this.examDate = examDate;
		this.questionBook = questionBook;
	}

	public int getIdExamination() {
		return idExamination;
	}

	public String getRefExamination() {
		return refExamination;
	}

	public CandidatesProfile getCandidatesProfile() {
		return candidatesProfile;
	}

	public int getExamMark() {
		return examMark;
	}

	public int getResultMark() {
		return resultMark;
	}

	public String getExamUrl() {
		return examUrl;
	}

	public int getStatus() {
		return status;
	}

	public Time getExamTotalTime() {
		return examTotalTime;
	}

	public Time getExamTime() {
		return examTime;
	}

	public Date getExamDate() {
		return examDate;
	}

	public List<QuestionBook> getQuestionBook() {
		return questionBook;
	}

	public void setIdExamination(int idExamination) {
		this.idExamination = idExamination;
	}

	public void setRefExamination(String refExamination) {
		this.refExamination = refExamination;
	}

	public void setCandidatesProfile(CandidatesProfile candidatesProfile) {
		this.candidatesProfile = candidatesProfile;
	}

	public void setExamMark(int examMark) {
		this.examMark = examMark;
	}

	public void setResultMark(int resultMark) {
		this.resultMark = resultMark;
	}

	public void setExamUrl(String examUrl) {
		this.examUrl = examUrl;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setExamTotalTime(Time examTotalTime) {
		this.examTotalTime = examTotalTime;
	}

	public void setExamTime(Time examTime) {
		this.examTime = examTime;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public void setQuestionBook(List<QuestionBook> questionBook) {
		this.questionBook = questionBook;
	}

	@Override
	public String toString() {
		return "Examination [idExamination=" + idExamination + ", refExamination=" + refExamination
				+ ", candidatesProfile=" + candidatesProfile + ", examMark=" + examMark + ", resultMark=" + resultMark
				+ ", examUrl=" + examUrl + ", status=" + status + ", examTotalTime=" + examTotalTime + ", examTime="
				+ examTime + ", examDate=" + examDate + ", questionBook=" + questionBook + "]";
	}
	
	
	
}
