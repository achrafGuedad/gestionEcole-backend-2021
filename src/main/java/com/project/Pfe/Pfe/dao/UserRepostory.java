package com.project.Pfe.Pfe.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.User;
import com.project.Pfe.Pfe.entities.appRole;

@Repository
public interface UserRepostory  extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
	
	@Query("select u  from User u where  u.username like :name")
	public User getUserByUsername(@Param("name") String username);
	
	
	@Query("select ur  from User ur ")
	public Page<User> getAllUsers(Pageable pageable);
	
	@Query("select COUNT (*) from  User cu")
	public  int getTotalFields();
	
	
	
	


}
