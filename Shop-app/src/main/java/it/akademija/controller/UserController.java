package it.akademija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.PagingData;
import it.akademija.model.CreateUserCommand;
import it.akademija.model.User;
import it.akademija.service.UserService;

@RestController
@Api(value = "user")
@RequestMapping(value = "/api/users")
public class UserController {
	
	private final UserService userService;
	private final PagingData pagingData;
	
	
	@Autowired
	public UserController(UserService userService, PagingData pagingData) {
		this.userService = userService;
		this.pagingData = pagingData;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get users", notes="Returns registered users")
	public List<User> getUsers() {
		pagingData.setLimit(2);
		return userService.getUsers();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create user", notes = "Creates user with data")
	public void createUser (@ApiParam(value="User data", required = true) @RequestBody final CreateUserCommand cmd) {
		userService.createUser(new User(cmd.getUserName(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail(), cmd.getAge()));
	}
	
	@RequestMapping(path ="/{userName}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete user", notes = "Deletes user according to the id specified in the path")
	public void deleteUser(@PathVariable final String userName) {
		userService.deleteUser(userName);
	}
	
	@RequestMapping(path = "find", method = RequestMethod.GET)
	public User findUser(@RequestParam String firstName, @RequestParam String lastName) {
		return userService.findByFirstNameAndLastName(firstName, lastName);
	}
	
	@RequestMapping(path = "/oldest", method = RequestMethod.GET)
	public User findOldestUser() {
		return userService.findOldestUser();
	}
}
