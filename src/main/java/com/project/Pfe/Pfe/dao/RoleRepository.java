package com.project.Pfe.Pfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.User;
import com.project.Pfe.Pfe.entities.appRole;

@Repository
public interface RoleRepository  extends JpaRepository<appRole, Integer>{

	public appRole findByRoleName(String roleName);
	
	@Query("select r from appRole r where r.roleName like :name")
	public appRole getRoleByRolename(@Param("name") String username);

}
