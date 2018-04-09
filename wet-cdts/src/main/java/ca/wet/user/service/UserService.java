package ca.wet.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import ca.wet.user.model.User;


@Service
public class UserService {
	private List<User> userList = new ArrayList<>();
	public List<User> getAllUsers(){
		return userList;
	}
	public void addUser(User user) {
		userList.add(user);
	}
	
	public List<User> getAllUsersMock(){
		User user = new User();
		user.setGender("female");
		user.setMarried(true);
		user.setProfile("VP");
		user.setUserId("111");
		user.setUserName("john doe");
		
		userList.add(user);
		
		return userList;
	}
} 