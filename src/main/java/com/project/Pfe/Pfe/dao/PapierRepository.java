package com.project.Pfe.Pfe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Niveau;
import com.project.Pfe.Pfe.entities.Papier;

@Repository
public interface PapierRepository extends JpaRepository<Papier, Integer>{

	
	
	@Query("select p from Papier p")
	public Page <Papier> getAllPapier(Pageable p);
	
	@Query("select COUNT (*) from  Papier p ")
	public  int totalFields();
}
