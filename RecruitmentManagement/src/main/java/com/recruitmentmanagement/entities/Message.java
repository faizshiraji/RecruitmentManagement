package com.recruitmentmanagement.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@Column(name = "id_message")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessage;
	private String subject;
	@Lob
	private String message;
	private String status;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date sentDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_users")
	private Users users;

	public Message() {
		super();
	}

	public Message(String subject, String message, String status, Date sentDate, Users users) {
		super();
		this.subject = subject;
		this.message = message;
		this.status = status;
		this.sentDate = sentDate;
		this.users = users;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage + ", subject=" + subject + ", message=" + message + ", status="
				+ status + ", sentDate=" + sentDate + ", users=" + users + "]";
	}
	
	
}
