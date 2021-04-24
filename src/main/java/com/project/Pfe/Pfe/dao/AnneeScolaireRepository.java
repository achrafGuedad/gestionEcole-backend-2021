package com.project.Pfe.Pfe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.AnneeScolaire;

@Repository
public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire, String>{
	
	@Query("select a from AnneeScolaire a where a.idAnneeScolaire like :annee")
	public AnneeScolaire getAnneeScolaireById(@Param("annee") int anneeSoclaire );
	
	@Query("select a from AnneeScolaire a where a.anneeScolaire like :annee")
	public AnneeScolaire getAnneeScolaireByYear(@Param("annee") String anneeSoclaire );
	

	
	

	
}
