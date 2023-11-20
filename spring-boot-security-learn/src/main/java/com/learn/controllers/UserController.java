package com.learn.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.models.Users;
import com.learn.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userServices;

	//all users
	
	@GetMapping("/")
	public List<Users> getAllUsers(){
		List<Users> allUsers = this.userServices.getAllUsers();
		return allUsers;
	}
	
	// return Single user
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{userName}")
	public Users getUser(@PathVariable("userName")String userName) {
		Users userbyId = this.userServices.getUser(userName);
		return userbyId;
		
	}
	
	// Create Users
	@PostMapping("/")
	public Users createUsers(@RequestBody Users users) {
		Users addUsers = this.userServices.addUsers(users);
		return addUsers;
		
	}
}
