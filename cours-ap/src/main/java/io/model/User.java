package io.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User{

    private String username;
    private String password;
    private String email;

    private boolean enabled = true;
    private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;
    private char userRole;
    
    public User() {
	}
	
    
    public User(String username, String password, String email,
			boolean enabled, boolean accountNonLocked,
			boolean accountNonExpired, char userRole) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.accountNonLocked = accountNonLocked;
		this.accountNonExpired = accountNonExpired;
		this.userRole = userRole;
	}


    public User(String username) {
        this();
        setUsername(username);
    }



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public char getUserRole() {
		return userRole;
	}
	public void setUserRole(char userRole) {
		this.userRole = userRole;
	}
    
    
}

