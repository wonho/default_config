package edu.showcase.business.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		List<SimpleGrantedAuthority> roleList = new ArrayList<SimpleGrantedAuthority>();
		
		roleList.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		UserDetails user = new User("test", "test", roleList);
		
		return user;
	}

}
