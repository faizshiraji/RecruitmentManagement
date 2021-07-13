package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.UserRole;

public interface UserRoleService {

	public List<UserRole> getUserRoles();
	
	public UserRole getUserRole(int idUserRole);
	
	public UserRole addUserRole(UserRole userRole);
	
	public UserRole updateUserRole(UserRole userRole);
	
	public void deleteUserRole(int idUserRole);
	
}
