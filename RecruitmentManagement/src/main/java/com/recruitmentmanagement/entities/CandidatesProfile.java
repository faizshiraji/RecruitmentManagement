package com.recruitmentmanagement.entities;

import java.util.ArrayList;
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
import javax.persistence.Table;
import com.recruitmentmanagement.entities.Examination;

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
	private Recruitment recruitment;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "candidates_profile_id")
	List<Examination> examination = new ArrayList<>();
	
	public CandidatesProfile() {
	}

	public CandidatesProfile(String fullName, int mobile, String email, int expSalary, String cv,
			Recruitment recruitment) {
		this.fullName = fullName;
		this.mobile = mobile;
		this.email = email;
		this.expSalary = expSalary;
		this.cv = cv;
		this.recruitment = recruitment;
	}

	public int getIdCandidatesProfile() {
		return idCandidatesProfile;
	}

	public String getFullName() {
		return fullName;
	}

	public int getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public int getExpSalary() {
		return expSalary;
	}

	public String getCv() {
		return cv;
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setIdCandidatesProfile(int idCandidatesProfile) {
		this.idCandidatesProfile = idCandidatesProfile;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExpSalary(int expSalary) {
		this.expSalary = expSalary;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	@Override
	public String toString() {
		return "CandidatesProfile [idCandidatesProfile=" + idCandidatesProfile + ", fullName=" + fullName + ", mobile="
				+ mobile + ", email=" + email + ", expSalary=" + expSalary + ", cv=" + cv + ", recruitment="
				+ recruitment + "]";
	}
	
	
	
}
