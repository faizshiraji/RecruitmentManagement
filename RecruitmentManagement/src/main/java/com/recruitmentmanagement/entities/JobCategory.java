package com.recruitmentmanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "job_category")
public class JobCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_job_category")
	private int idJobCategory;
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "jobCategory")
	private List<JobCircular> jobCirculars;;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "jobCategory")
	private List<QuestionBook> questionBooks;

	public JobCategory() {
	}

	public JobCategory(String categoryName, List<JobCircular> jobCirculars, List<QuestionBook> questionBooks) {
		super();
		this.categoryName = categoryName;
		this.jobCirculars = jobCirculars;
		this.questionBooks = questionBooks;
	}

	public int getIdJobCategory() {
		return idJobCategory;
	}

	public void setIdJobCategory(int idJobCategory) {
		this.idJobCategory = idJobCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<JobCircular> getJobCirculars() {
		return jobCirculars;
	}

	public void setJobCirculars(List<JobCircular> jobCirculars) {
		this.jobCirculars = jobCirculars;
	}

	public List<QuestionBook> getQuestionBooks() {
		return questionBooks;
	}

	public void setQuestionBooks(List<QuestionBook> questionBooks) {
		this.questionBooks = questionBooks;
	}

	
}
