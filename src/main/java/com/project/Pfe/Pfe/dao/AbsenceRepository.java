package com.project.Pfe.Pfe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Absence;
import com.project.Pfe.Pfe.entities.Controle;


@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Integer> {


	@Query("select a from Absence a where a.etudiant.immat like :immat and a.classe.idClasse like :idClasse")
	public  Page<Absence> getStudentAbsence(@Param("immat") int immat,@Param("idClasse") int idClasse,Pageable pageable);
	
	@Query("select COUNT(*) from Absence a where a.etudiant.immat like :immat and a.classe.idClasse like :idClasse")
	public int getTotalFields(@Param("immat") int immat,@Param("idClasse") int idClasse);

}
