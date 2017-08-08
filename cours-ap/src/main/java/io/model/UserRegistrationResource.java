package io.model;

public class UserRegistrationResource {

	private String username; 
	private String email; 

	protected UserRegistrationResource() {
    }

	public UserRegistrationResource(UserRegistrationApiData userRegistration) {
        this.username = userRegistration.getUsername();
        this.email = userRegistration.getEmail();
    }


}
