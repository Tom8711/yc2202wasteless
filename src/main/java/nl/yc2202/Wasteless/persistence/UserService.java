package nl.yc2202.Wasteless.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.User;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public void CreateUser(User user) {
		ur.save(user);
	}
	
	public Optional<User> FindUserById(long userid) {
		return ur.findById(userid);
	}
	
	public User FindUserByUsername(String username, String password) {
		User user = ur.findByUsername(username);
		if(user.getPassword().equals(password)) {
			return user;
		}
		return null;
				
	}
}
