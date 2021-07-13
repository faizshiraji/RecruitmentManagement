package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {

}
