package com.project.Pfe.Pfe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.Pfe.Pfe.entities.Controle;
import com.project.Pfe.Pfe.entities.DemandePapier;

@Repository
public interface DemandePapierRepository  extends JpaRepository<DemandePapier, Integer>{

	@Query("select d from DemandePapier d where d.Etat LIKE :etat ")
	public  Page<DemandePapier> getDemandes(@Param("etat") String etat,Pageable pageable);	
	
	@Query("select COUNT (*) from DemandePapier dp where dp.Etat like :etat")
	public  int getTotalFields(@Param("etat") String etat);	
	
	@Query("select d from DemandePapier d where d.etudiant.immat like :immat")
    public Page<DemandePapier> getDemandeOfStudent(@Param("immat") int immat,Pageable pageable);
	
	@Query("select COUNT(*) from DemandePapier d where d.etudiant.immat like :immat")
	public int countDemandOfStudent(@Param("immat") int immat);




	
}










