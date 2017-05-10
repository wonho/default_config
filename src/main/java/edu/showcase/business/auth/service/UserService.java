package edu.showcase.business.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		List<SimpleGrantedAuthority> roleList = new ArrayList<SimpleGrantedAuthority>();
		
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		
		String encodePassword = passwordEncoder.encodePassword("test", null);
		
		roleList.add(new SimpleGrantedAuthority("ROLE_USER"));
		
//		UserDetails user = new User("test", "test", roleList);
		
		UserDetails user = new User("test", encodePassword, roleList);
		
		
		return user;
	}

}
