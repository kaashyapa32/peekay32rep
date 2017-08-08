package io.services;

import io.model.User;
import io.model.UserRegistrationApiData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

		private static Map<String,User> userMap = new HashMap<>();
		
		
		//virtual-database
		static
		{
			userMap.put("aaa",new User("aaa", "****", "123@xyz.com", true, true, true, 'u'));
			userMap.put("bbb",new User("bbb", "****", "234@xyx.com", true, true, true, 'a'));
		}

		
		public User findUserByUsername(String username) {
			System.out.println("called" + username);
			return userMap.get(username);
		}


		public void saveUser(User newUser, UserRegistrationApiData userRegistration) {
			if (!userMap.containsKey(newUser.getUsername()))
			{
				newUser.setEmail(userRegistration.getEmail());
		        newUser.setPassword(userRegistration.getPassword());
		        newUser.setEnabled(false);
		        newUser.setAccountNonLocked(false);
		        newUser.setAccountNonExpired(false);
				userMap.put(newUser.getUsername(), newUser);
			}

		}


		public List<User> getUsers() {
			return new ArrayList<>(userMap.values());
		}
}
