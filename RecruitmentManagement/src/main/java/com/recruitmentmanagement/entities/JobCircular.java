package com.recruitmentmanagement.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "job_circular")
public class JobCircular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idJobCircular;
	private int vacancy;
	@Column(name = "job_name")
	private String jobName;
	@Lob
	private String jobDetails;
	
	private String employmentStatus;
	
	private String educationRequirement;
	
	private String experienceRequirement;
	
	@Lob
	private String additionalRequirement;
	
	private String workplace;
	
	private String jobLocation;
	
	private String salary;
	
	@Column(name = "others_benefits")
	private String othersBenefits;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date publishDate;
	
	private String status;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_job_category")
	private JobCategory jobCategory;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "jobCircular")
	private Recruitment recruitment;
	
	public JobCircular() {
	}

	public JobCircular(int vacancy, String jobName, String jobDetails, String employmentStatus,
			String educationRequirement, String experienceRequirement, String additionalRequirement, String workplace,
			String jobLocation, String salary, String othersBenefits, Date publishDate, String status,
			JobCategory jobCategory, Recruitment recruitment) {
		super();
		this.vacancy = vacancy;
		this.jobName = jobName;
		this.jobDetails = jobDetails;
		this.employmentStatus = employmentStatus;
		this.educationRequirement = educationRequirement;
		this.experienceRequirement = experienceRequirement;
		this.additionalRequirement = additionalRequirement;
		this.workplace = workplace;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.othersBenefits = othersBenefits;
		this.publishDate = publishDate;
		this.status = status;
		this.jobCategory = jobCategory;
		this.recruitment = recruitment;
	}

	public int getIdJobCircular() {
		return idJobCircular;
	}

	public void setIdJobCircular(int idJobCircular) {
		this.idJobCircular = idJobCircular;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getEducationRequirement() {
		return educationRequirement;
	}

	public void setEducationRequirement(String educationRequirement) {
		this.educationRequirement = educationRequirement;
	}

	public String getExperienceRequirement() {
		return experienceRequirement;
	}

	public void setExperienceRequirement(String experienceRequirement) {
		this.experienceRequirement = experienceRequirement;
	}

	public String getAdditionalRequirement() {
		return additionalRequirement;
	}

	public void setAdditionalRequirement(String additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getOthersBenefits() {
		return othersBenefits;
	}

	public void setOthersBenefits(String othersBenefits) {
		this.othersBenefits = othersBenefits;
	}

	public java.util.Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(java.util.Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobCategory getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	@Override
	public String toString() {
		return "JobCircular [idJobCircular=" + idJobCircular + ", vacancy=" + vacancy + ", jobName=" + jobName
				+ ", jobDetails=" + jobDetails + ", employmentStatus=" + employmentStatus + ", educationRequirement="
				+ educationRequirement + ", experienceRequirement=" + experienceRequirement + ", additionalRequirement="
				+ additionalRequirement + ", workplace=" + workplace + ", jobLocation=" + jobLocation + ", salary="
				+ salary + ", othersBenefits=" + othersBenefits + ", publishDate=" + publishDate + ", status=" + status
				+ ", jobCategory=" + jobCategory + ", recruitment=" + recruitment + "]";
	}

	
}
