package com.recruitmentmanagement.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recruitment_status")
public class RecruitmentStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecruitmentStatus;
	private int status;
	private String statusDescription;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Recruitment recruitment;

	public RecruitmentStatus() {
	}

	public RecruitmentStatus(int status, String statusDescription, Recruitment recruitment) {
		this.status = status;
		this.statusDescription = statusDescription;
		this.recruitment = recruitment;
	}

	public int getIdRecruitmentStatus() {
		return idRecruitmentStatus;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setIdRecruitmentStatus(int idRecruitmentStatus) {
		this.idRecruitmentStatus = idRecruitmentStatus;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	@Override
	public String toString() {
		return "RecruitmentStatus [idRecruitmentStatus=" + idRecruitmentStatus + ", status=" + status
				+ ", statusDescription=" + statusDescription + ", recruitment=" + recruitment + "]";
	}
	
	
}
