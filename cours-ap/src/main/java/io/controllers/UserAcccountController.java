package io.controllers;

import io.model.User;
import io.model.UserRegistrationApiData;
import io.model.UserRegistrationResource;
import io.services.UserService;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserAcccountController {
	
		private UserService userService = new UserService();
		
		//Produces both JSON and XML
		@RequestMapping(value="/{username}",produces=MediaType.APPLICATION_JSON)
		public User getUser(@PathVariable("username") String username)
		{
			System.out.println("called");
			return userService.findUserByUsername(username);
		}
		
		@RequestMapping(method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON)
		public ResponseEntity<UserRegistrationResource> registerUser(@RequestBody UserRegistrationApiData userRegistration) {
			
			if(userRegistration.getUsername().equals(null))
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
			if (userService.findUserByUsername(userRegistration.getUsername()) != null) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
			User newUser = new User(userRegistration.getUsername());
	        
	        userService.saveUser(newUser,userRegistration);

			return new ResponseEntity<>(new UserRegistrationResource(userRegistration), HttpStatus.CREATED);
		}
		
		@RequestMapping(produces=MediaType.APPLICATION_JSON,method=RequestMethod.GET)
		public List<User> getUser()
		{
			return userService.getUsers();
		}

}
