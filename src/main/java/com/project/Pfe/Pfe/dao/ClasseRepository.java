package com.project.Pfe.Pfe.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Matiere;
import com.project.Pfe.Pfe.entities.Niveau;
@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {
	
	@Query("select c from Classe c where c.idClasse like :idClasse")
	public Classe getClasseById(@Param("idClasse") int idClasse );
	
	
	@Query("select c from Classe c where c.anneeScolaire.idAnneeScolaire like :idAnnee")
	public Page <Classe> getClassesByAnneeScolaire(@Param("idAnnee") int idAnnee,Pageable pageable );
	
	
	@Query("select DISTINCT dc.idClasse   from  Classe dc ")
	public List <Classe> getDistinctClasses();
	
	
	@Query("select COUNT(*) from  Classe tc where tc.anneeScolaire.idAnneeScolaire like :id  ")
	public int getTotalFields(@Param("id") int idAnnee);
	
	
	@Query("select c from Classe c where c.anneeScolaire.anneeScolaire like :annee")
	public List <Classe> getAllClassesByAnneeScolaire(@Param("annee") String annee );
	
	@Query("select DISTINCT c from Classe c where c.idClasse like :idClasse")
	public Classe getClasseByIdClasse(@Param("idClasse") int idLevel);
	
	
	

	

}
