package com.recruitmentmanagement.entities.custom;

public class QuestionBookForm {

	private int jobCategory;
	private String question;
	private int answerOption;
	
	public QuestionBookForm() {
		super();
	}

	public int getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(int jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(int answerOption) {
		this.answerOption = answerOption;
	}

	@Override
	public String toString() {
		return "QuestionBookForm [jobCategory=" + jobCategory + ", question=" + question + ", answerOption="
				+ answerOption + "]";
	}


	
	
	
}
