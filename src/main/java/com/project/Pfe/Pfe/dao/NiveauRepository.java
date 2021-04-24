package com.project.Pfe.Pfe.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Filiere;
import com.project.Pfe.Pfe.entities.Niveau;

@Repository
public interface NiveauRepository  extends JpaRepository<Niveau,Integer>{


	@Query("select  n from Niveau n where n.idNiveau like :x")
	public Niveau getNiveauById(@Param("x") int idNiveau);
	
	@Query("select COUNT (*) from  Niveau nbNiveau ")
	public  int totalFields();
	
	
	@Query("select np from Niveau np")
	public Page <Niveau> getAllLevels(Pageable p);
	
	
	
}
