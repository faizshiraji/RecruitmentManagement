package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.UserRole;
import com.recruitmentmanagement.repo.UserRoleRepo;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	public UserRoleRepo userRoleRepo;
	
	@Override
	public List<UserRole> getUserRoles() {
		return userRoleRepo.findAll();
	}

	@Override
	public UserRole getUserRole(int idUserRole) {
		return userRoleRepo.findById(idUserRole).get();
	}

	@Override
	public UserRole addUserRole(UserRole userRole) {
		return userRoleRepo.save(userRole);
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		return userRoleRepo.save(userRole);
	}

	@Override
	public void deleteUserRole(int idUserRole) {
		userRoleRepo.deleteById(idUserRole);
	}

}
