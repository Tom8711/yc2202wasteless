package nl.yc2202.Wasteless.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.domein.User;
import nl.yc2202.Wasteless.persistence.UserService;



@RestController
public class UserEndpoint {

	@Autowired
	UserService as;
	
	@PostMapping("/createuser")
	public void createUser(@RequestBody User user) {
		as.CreateUser(user);
	}
}
