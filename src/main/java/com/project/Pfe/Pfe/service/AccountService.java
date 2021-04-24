package com.project.Pfe.Pfe.service;

import com.project.Pfe.Pfe.entities.User;
import com.project.Pfe.Pfe.entities.appRole;

public interface AccountService {
	public appRole SaveRole(appRole role);
	public User SaveUser(User user);
	public User getUserByUsername(String username);
	public appRole getRoleByRolename(String rolename);
	public void addRoleToUser(String userName,String roleName);
	public boolean deleteUser(int idUser);
	
	public User SaveUserEtudiant(User user);
}
