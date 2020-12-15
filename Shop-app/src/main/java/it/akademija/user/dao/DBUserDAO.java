package it.akademija.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.akademija.user.model.User;

@Qualifier("databaseDao")
public interface DBUserDAO extends JpaRepository<User, Integer>, UserDao {
	
	default List<User> getUsers() {
		return this.findAll();
	}
	
	default void createUser(User user) {
		this.save(user);
	}
	
	default void deleteUser(String userName) {
		this.deleteByUserName(userName);
	}
	
	void deleteByUserName(String userName);
	
	User findByFirstNameAndLastName(String firstName, String lastName);
	
	//@Query("select u from User u where u.id = (select min(u.id) from User u where (select max(u.age) from User))")
	default User findOldestUser() {
		return this.findFirstByOrderByAgeDesc();
	}
	
	User findFirstByOrderByAgeDesc();

}
