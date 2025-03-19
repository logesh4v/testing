package com.user.user_microservice.service;

import java.util.List;
 
import com.user.user_microservice.model.User;
 
public interface UserService {

	List<User> getAllUsers();

	User getUserById(Long id);

	User createUser(User user);

	User updateUser(Long id,User user);

	void deleteUser(Long id);

}

 
 