package it.akademija.user.dao;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import it.akademija.user.model.User;

@Repository
public class InMemoryUserDAO implements UserDao {
	
	private final List<User> users = new CopyOnWriteArrayList<>();
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(users);
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		users.add(user);
	}

	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub
		for (User user: users) {
			if (userName.equals(user.getUserName())) {
				users.remove(user);
				break;
			}
		}
	}

}
