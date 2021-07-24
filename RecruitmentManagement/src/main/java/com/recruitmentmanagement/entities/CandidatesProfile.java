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
@Table(name = "candidates_profile")
public class CandidatesProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidates_profile_id")
	private int idCandidatesProfile;
	private String fullName;
	private int mobile;
	private String email;
	private int expSalary;
	private String cv;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_recruitment")
	private Recruitment recruitment;

	@OneToMany(mappedBy = "candidatesProfile")
	List<Examination> examination;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidatesProfile")
	private Users users;
	
	public CandidatesProfile() {
	}

	public CandidatesProfile(String fullName, int mobile, String email, int expSalary, String cv,
			Recruitment recruitment, List<Examination> examination, Users users) {
		super();
		this.fullName = fullName;
		this.mobile = mobile;
		this.email = email;
		this.expSalary = expSalary;
		this.cv = cv;
		this.recruitment = recruitment;
		this.examination = examination;
		this.users = users;
	}

	public int getIdCandidatesProfile() {
		return idCandidatesProfile;
	}

	public void setIdCandidatesProfile(int idCandidatesProfile) {
		this.idCandidatesProfile = idCandidatesProfile;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExpSalary() {
		return expSalary;
	}

	public void setExpSalary(int expSalary) {
		this.expSalary = expSalary;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	public List<Examination> getExamination() {
		return examination;
	}

	public void setExamination(List<Examination> examination) {
		this.examination = examination;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "CandidatesProfile [idCandidatesProfile=" + idCandidatesProfile + ", fullName=" + fullName + ", mobile="
				+ mobile + ", email=" + email + ", expSalary=" + expSalary + ", cv=" + cv + ", recruitment="
				+ recruitment + ", examination=" + examination + ", users=" + users + "]";
	}
	
	

}
