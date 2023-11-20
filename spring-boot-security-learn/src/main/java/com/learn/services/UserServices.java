package com.learn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.models.Users;

@Service
public class UserServices {
	List<Users> list = new ArrayList<>();

	public UserServices() {
		list.add(new Users("Rahul","abc","rahul@gmail.com"));
		list.add(new Users("Himanshu","him","himanshu@gmail.com"));
	}
	
	// get all users
	
	public List<Users> getAllUsers(){
		
		return this.list;
	}
	
	// get the single user
	
	public Users getUser(String userName) {
		
		return this.list.stream().filter((users) -> users.getUserName().equals(userName)).findAny().orElse(null);
		
	}
	
	// add the user
	
	public Users addUsers(Users users) {
		 this.list.add(users);
		 return users;
	}
	

}
