package it.akademija.user.dao;

import java.util.List;

import it.akademija.user.model.User;

public interface UserDao {
	
	List<User> getUsers();
	
	void createUser(User user);
	
	void deleteUser(String userName);
}
