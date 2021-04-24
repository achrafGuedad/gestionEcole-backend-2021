package com.project.Pfe.Pfe.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Controle;

@Repository
public interface ControleRepository  extends JpaRepository<Controle, Integer> {

	@Query("select c from Controle c where c.etudiant.immat like :immat and c.classe.idClasse like :idClasse")
	public  Page<Controle> getNotesOfStudent(@Param("immat") int immat,@Param("idClasse") int idClasse,Pageable pageable);	

	
	@Query("select COUNT (*) from Controle c where c.etudiant.immat like :immat and c.classe.idClasse like :idClasse")
	public int getTotalFields(@Param("immat") int immat,@Param("idClasse") int idClasse);



	@Query("select c from Controle c where c.etudiant.immat like :immat and c.classe.idClasse like :idClasse and c.matiere.idMatiere like :idMatiere")
	public List<Controle> generateBulletin(@Param("immat") int immat,@Param("idClasse") int idClasse,@Param("idMatiere") int idMatiere);
}


