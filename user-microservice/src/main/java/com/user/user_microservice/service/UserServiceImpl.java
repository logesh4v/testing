package com.user.user_microservice.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
 
import com.user.user_microservice.model.User;

import com.user.user_microservice.repository.UserRepository;
 
@Service

public class UserServiceImpl implements UserService{
 
	@Autowired

	private UserRepository userRepository;
 
	@Override

	public List<User> getAllUsers() {

		// TODO Auto-generated method stub

		return userRepository.findAll();

	}
 
	@Override

	public User getUserById(Long id) {

		// TODO Auto-generated method stub

		return userRepository.findById(id).orElse(null);

	}
 
	@Override

	public User createUser(User user) {

		// TODO Auto-generated method stub

		return userRepository.save(user);

	}
 
	@Override

	public User updateUser(Long id, User user) {

		// TODO Auto-generated method stub

		User existingUser = userRepository.findById(id).orElse(null);

		if(existingUser != null) {

			existingUser.setUsername(user.getUsername());

			existingUser.setEmail(user.getEmail());

			existingUser.setPassword(user.getPassword());

			return userRepository.save(existingUser);

		}

		return null;

	}
 
	@Override

	public void deleteUser(Long id) {

		// TODO Auto-generated method stub

		userRepository.deleteById(id);

	}


}

 