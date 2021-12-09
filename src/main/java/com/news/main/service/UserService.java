package com.news.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.news.main.dto.UserRegistrationDto;
import com.news.main.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.news.main.entity.User;
import com.news.main.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	//METHOD GET ALL USERS LIST
	public List<User> getAllUsers() {
		
		List<User> users = new ArrayList<User>();
		
		userRepository.findAll().forEach(users::add);
				          
		return users;
	}
	
	//METHOD GET USER BY USERNAME
	public User getUserByUsername(int id) {
		
		return userRepository.findById(id).get();
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
	public void delete(int id) {
		
		userRepository.deleteById(id);
	}



	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getUsername(), registrationDto.getSurname(),
								passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getEmail(),
								Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());



	}
}
