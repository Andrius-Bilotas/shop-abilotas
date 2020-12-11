package it.akademija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.dao.DBUserDAO;
import it.akademija.dao.UserDao;
import it.akademija.model.User;

@Service
public class UserService {

	@Autowired
	@Qualifier("databaseDao")
	private UserDao userDao;

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Transactional
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Transactional
	public void deleteUser(String userName) {
		userDao.deleteUser(userName);
	}
	
	@Transactional
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		return ((DBUserDAO)userDao).findByFirstNameAndLastName(firstName, lastName);
	}
	
	@Transactional
	public User findOldestUser() {
		return ((DBUserDAO)userDao).findOldestUser();
	}

}
