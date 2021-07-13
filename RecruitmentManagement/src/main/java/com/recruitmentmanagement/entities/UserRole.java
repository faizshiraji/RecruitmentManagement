package com.recruitmentmanagement.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {

	@Id
	@Column(name = "iduser_role")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUserRole;
	private String roleName;
	
	@OneToMany(mappedBy = "userRole")
	private List<Users> users;

	public UserRole() {
	}

	public int getIdUserRole() {
		return idUserRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setIdUserRole(int idUserRole) {
		this.idUserRole = idUserRole;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	
	
}
