package com.project.Pfe.Pfe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Filiere;

@Repository
public interface FiliereRepository  extends JpaRepository<Filiere,Integer>{
	
	@Query("select f from Filiere f where f.codeFiliere like :x")
	public Filiere getFiliereByiid(@Param("x") int idFiliere);
	
	@Query("select fp from Filiere fp")
	public Page <Filiere> getAllFiliere(Pageable p);
	
	@Query("select COUNT (*) from  Filiere nbFiliere ")
	public  int totalFields();
	

}
