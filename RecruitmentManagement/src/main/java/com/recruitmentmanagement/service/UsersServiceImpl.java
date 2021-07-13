package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.Users;
import com.recruitmentmanagement.repo.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	public UsersRepo usersRepo;
	
	@Override
	public List<Users> getUsers() {
		return usersRepo.findAll();
	}

	@Override
	public Users getUsers(int idUsers) {
		return usersRepo.findById(idUsers).get();
	}

	@Override
	public Users getUsersByUsers(String userName) {
		return usersRepo.findByUserName(userName);
	}

	@Override
	public Users addUsers(Users users) {
		return usersRepo.save(users);
	}

	@Override
	public Users updateUsers(Users users) {
		return usersRepo.save(users);
	}

	@Override
	public void deleteUsers(int idUsers) {
		Users users = usersRepo.getOne(idUsers);
		usersRepo.delete(users);
	}

	@Override
	public long countUsers() {
		return usersRepo.count();
	}

}
