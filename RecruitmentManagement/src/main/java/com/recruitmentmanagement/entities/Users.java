package com.recruitmentmanagement.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_users")
	private int idUsers;
	private String userName;
	private String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "iduser_role")
	private UserRole userRole;

	@OneToMany(mappedBy = "users")
	List<Recruitment> recruitments;
	
	@OneToMany(mappedBy = "users")
	List<Message> messages;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_id")
	private CandidatesProfile candidatesProfile;
	
	public Users() {
	}

	public Users(String userName, String password, UserRole userRole, List<Recruitment> recruitments,
			List<Message> messages, CandidatesProfile candidatesProfile) {
		super();
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.recruitments = recruitments;
		this.messages = messages;
		this.candidatesProfile = candidatesProfile;
	}

	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<Recruitment> getRecruitments() {
		return recruitments;
	}

	public void setRecruitments(List<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public CandidatesProfile getCandidatesProfile() {
		return candidatesProfile;
	}

	public void setCandidatesProfile(CandidatesProfile candidatesProfile) {
		this.candidatesProfile = candidatesProfile;
	}

	@Override
	public String toString() {
		return "Users [idUsers=" + idUsers + ", userName=" + userName + ", password=" + password + ", userRole="
				+ userRole + ", recruitments=" + recruitments + ", messages=" + messages + ", candidatesProfile="
				+ candidatesProfile + "]";
	}

	

	
}
