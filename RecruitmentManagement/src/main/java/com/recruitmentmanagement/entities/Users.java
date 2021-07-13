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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private UserRole userRole;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_users")
	List<Recruitment> recruitments = new ArrayList<>();
	
	public Users() {
	}

	public Users(String userName, String password, UserRole userRole, List<Recruitment> recruitments) {
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.recruitments = recruitments;
	}

	public int getIdUsers() {
		return idUsers;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public List<Recruitment> getRecruitments() {
		return recruitments;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public void setRecruitments(List<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}

	@Override
	public String toString() {
		return "Users [idUsers=" + idUsers + ", userName=" + userName + ", password=" + password + ", userRole="
				+ userRole + ", recruitments=" + recruitments + "]";
	}

	
	
	
}
