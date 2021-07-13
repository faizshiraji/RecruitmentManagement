package com.recruitmentmanagement.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer_book")
public class AnswerBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_answer_book")
	private int idAnswerBook;
	private String answer;
	private boolean correctAnswer;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_question_book")
//	private QuestionBook questionBook;

	public AnswerBook() {
		super();
	}

	public AnswerBook(String answer, boolean correctAnswer) {
		super();
		this.answer = answer;
		this.correctAnswer = correctAnswer;
	}

	public int getIdAnswerBook() {
		return idAnswerBook;
	}

	public void setIdAnswerBook(int idAnswerBook) {
		this.idAnswerBook = idAnswerBook;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "AnswerBook [idAnswerBook=" + idAnswerBook + ", answer=" + answer + ", correctAnswer=" + correctAnswer
				+ "]";
	}

	
}
