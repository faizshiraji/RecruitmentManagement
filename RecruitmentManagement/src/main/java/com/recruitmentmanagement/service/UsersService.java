package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.Users;

public interface UsersService {

	public List<Users> getUsers();
	
	public Users getUsers(int idUsers);
	
	public Users getUsersByUsers(String userName);
	
	public Users addUsers(Users users);
	
	public Users updateUsers(Users users);
	
	public void deleteUsers(int idUsers);
	
	public long countUsers();
	
}
