package com.recruitmentmanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "recruitment")
public class Recruitment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecruitment;
	private String refRecruitment; 
	private int status;

	@ManyToOne(cascade = CascadeType.ALL)
	private Users users;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_circular_id")
	private JobCircular jobCircular;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recruitment_id")
	List<RecruitmentStatus> recruitmentStatus = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recruitment_id")
	List<CandidatesProfile> candidatesProfiles = new ArrayList<>();
	
	public Recruitment() {
	}

	public Recruitment(String refRecruitment, int status, Users users, JobCircular jobCircular,
			List<RecruitmentStatus> recruitmentStatus, List<CandidatesProfile> candidatesProfiles) {
		this.refRecruitment = refRecruitment;
		this.status = status;
		this.users = users;
		this.jobCircular = jobCircular;
		this.recruitmentStatus = recruitmentStatus;
		this.candidatesProfiles = candidatesProfiles;
	}

	public int getIdRecruitment() {
		return idRecruitment;
	}

	public String getRefRecruitment() {
		return refRecruitment;
	}

	public int getStatus() {
		return status;
	}

	public Users getUsers() {
		return users;
	}

	public JobCircular getJobCircular() {
		return jobCircular;
	}

	public List<RecruitmentStatus> getRecruitmentStatus() {
		return recruitmentStatus;
	}

	public List<CandidatesProfile> getCandidatesProfiles() {
		return candidatesProfiles;
	}

	public void setIdRecruitment(int idRecruitment) {
		this.idRecruitment = idRecruitment;
	}

	public void setRefRecruitment(String refRecruitment) {
		this.refRecruitment = refRecruitment;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setJobCircular(JobCircular jobCircular) {
		this.jobCircular = jobCircular;
	}

	public void setRecruitmentStatus(List<RecruitmentStatus> recruitmentStatus) {
		this.recruitmentStatus = recruitmentStatus;
	}

	public void setCandidatesProfiles(List<CandidatesProfile> candidatesProfiles) {
		this.candidatesProfiles = candidatesProfiles;
	}

	
}
