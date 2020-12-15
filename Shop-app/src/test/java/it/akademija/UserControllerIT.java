package it.akademija;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import it.akademija.user.model.CreateUserCommand;
import it.akademija.user.model.User;

@RunWith(SpringRunner.class) 
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { App.class })
public class UserControllerIT {
	
	private static final String URI = "/api/users";
	
	@Autowired
	private TestRestTemplate rest;
	
	@Test
	public void createsUserThenRetrievesUserListAndDeletesUser() {
		final String userName = "testUsername";
		final CreateUserCommand createUser = new CreateUserCommand();
		
		createUser.setUserName(userName);
		rest.postForLocation(URI, createUser);
		List<User> users = rest.getForEntity(URI, List.class).getBody();
		
		Assert.assertThat(users.size(), CoreMatchers.is(1));
		rest.delete(URI + "/" + userName);
		users = rest.getForEntity(URI, List.class).getBody();
		Assert.assertThat(users.size(), CoreMatchers.is(0));
	}
}
