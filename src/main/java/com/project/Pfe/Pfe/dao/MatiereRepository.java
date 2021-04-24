package com.project.Pfe.Pfe.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Filiere;
import com.project.Pfe.Pfe.entities.Matiere;
import com.project.Pfe.Pfe.entities.Niveau;

@Repository
public interface MatiereRepository  extends JpaRepository<Matiere, Integer>{
	
	@Query("select m from Matiere m where m.niveau.idNiveau like :x")
	public List<Matiere> getMatiereGroupByLibeelle(@Param("x") int idNiveau);
	
	
	

	@Query("select m from Matiere m where m.niveau.idNiveau like :x")
	public Page <Matiere> getAllMatiere(@Param("x") int idNiveau,Pageable p);
	
	@Query("select COUNT (*) from  Matiere nbm where nbm.niveau.idNiveau like :id")
	public  int totalFields(@Param("id") int idNiveau);	
	
	
	
}
