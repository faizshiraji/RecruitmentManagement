package com.recruitmentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitmentmanagement.entities.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
	Users findByUserName(String userName);
}
