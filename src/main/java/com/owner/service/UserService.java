package com.owner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.owner.model.User;
import com.owner.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		List<User> users=new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public void updateUser(Long userId, User user) {
		userRepository.save(user);		
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);		
	}

}
