package com.project.Pfe.Pfe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Planing;

@Repository
public interface PlaningRepository  extends JpaRepository<Planing, Integer>{

	@Query("select p from Planing p where p.classe.idClasse like :x")
   public  List<Planing>getListPlaningByClassId(@Param("x") int idClasse);
	
	
	@Query("select DISTINCT (p.classe) from Planing p where p.prof.idUser like :idProf and p.classe.anneeScolaire.idAnneeScolaire like :idYear ")
	public  List<Classe> getClassesByCurrentYear(@Param("idProf") int idProf,@Param("idYear") int idYear);
	
	@Query("select  plan from Planing plan where plan.classe.idClasse like :idClasse and plan.prof.idUser like :idUser")
	public  List<Planing> getMatiereOfProf(@Param("idClasse") int idClasse,@Param("idUser") int idUser);
}
    