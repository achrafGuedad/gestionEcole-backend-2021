package com.project.Pfe.Pfe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Integer> {
	
	
	
	

	@Query("select s from Salle s")
	public Page <Salle> getAllSalle(Pageable p);
	
	@Query("select COUNT (*) from  Salle s")
	public  int totalFields();	
	

}
