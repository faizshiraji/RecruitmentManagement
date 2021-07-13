package com.recruitmentmanagement.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questionbook")
public class QuestionBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_question_book")
	private int idQuestionBook;
	@Lob
	private String question;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_qb")
	private List<AnswerBook> answerBook;
	
	@Column(name = "option_ans")
	private int option;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_job_category")
	private JobCategory jobCategory;

	public QuestionBook() {
		super();
	}

	public QuestionBook(String question, List<AnswerBook> answerBook, int option, JobCategory jobCategory) {
		super();
		this.question = question;
		this.answerBook = answerBook;
		this.option = option;
		this.jobCategory = jobCategory;
	}

	public int getIdQuestionBook() {
		return idQuestionBook;
	}

	public void setIdQuestionBook(int idQuestionBook) {
		this.idQuestionBook = idQuestionBook;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerBook> getAnswerBook() {
		return answerBook;
	}

	public void setAnswerBook(List<AnswerBook> answerBook) {
		this.answerBook = answerBook;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public JobCategory getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	@Override
	public String toString() {
		return "QuestionBook [idQuestionBook=" + idQuestionBook + ", question=" + question + ", answerBook="
				+ answerBook + ", option=" + option + ", jobCategory=" + jobCategory + "]";
	}


	
}
