package com.project.Pfe.Pfe.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.UserRepostory;
import com.project.Pfe.Pfe.entities.User;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	 @Autowired 
	 private AccountService  accountService;
	 
	 @Autowired
	 private UserRepostory userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

		 User user=userRepository.getUserByUsername(username);
        if (user == null)
        throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getUserRoles().forEach(r->{
        	authorities.add(new SimpleGrantedAuthority(r.getRoleName()) ) ;
        });
        //authorities.add(new SimpleGrantedAuthority(user.getUserRoles().getRoleName())); 
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
		
	}

}
