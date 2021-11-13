package com.news.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.main.entity.User;
import com.news.main.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	//METHOD GET ALL USERS LIST
	public List<User> getAllUsers() {
		
		List<User> users = new ArrayList<User>();
		
		userRepository.findAll().forEach(users::add);
				          
		return users;
	}
	
	//METHOD GET USER BY USERNAME
	public User getUserByUsername(String username) {
		
		return userRepository.findById(username).get();
	}
	
	//METHOD ADD NEW USER
	public void addUser(User user) {
		
	     userRepository.save(user);
	}
	
	//METHOD UPDATE USER
	public void updateUser(User user, String username) {
		
		userRepository.save(user);
	}
	
	//METHOD DELETE USER
	public void delete(String username) {
		
		userRepository.deleteById(username);
	}
	
	

}
