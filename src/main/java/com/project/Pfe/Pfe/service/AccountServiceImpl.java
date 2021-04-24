package com.project.Pfe.Pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.RoleRepository;
import com.project.Pfe.Pfe.dao.UserRepostory;
import com.project.Pfe.Pfe.entities.User;
import com.project.Pfe.Pfe.entities.appRole;

@Service
public class AccountServiceImpl  implements AccountService{

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRepostory userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public appRole SaveRole(appRole role) {
      return null;
	}

	@Override
	public User SaveUser(User user) {
		  String passwordEncoded=bCryptPasswordEncoder.encode(user.getPassword());
		  user.setPassword(passwordEncoded);	
		   return userRepository.save(user);
	}
	
	@Override
	public User SaveUserEtudiant(User user) {
		  String passwordEncoded=bCryptPasswordEncoder.encode(user.getPassword());
		  user.setPassword(passwordEncoded);	
		   return userRepository.save(user);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		appRole role=roleRepository.getRoleByRolename(roleName);
        User user=userRepository.getUserByUsername(userName);
        user.getUserRoles().add(role);
		
	}

	@Override
	public User getUserByUsername(String username) {
        User user=userRepository.findByUsername(username);
		return user;
	}

	@Override
	public appRole getRoleByRolename(String rolename) {
        appRole role=roleRepository.findByRoleName(rolename);
		return role;
	}

	@Override
	public boolean deleteUser(int idUser) {
      
		userRepository.deleteById(idUser);
		return true;
		
	}

	
}
