package com.project.Pfe.Pfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Filiere;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{
	


	Etudiant findByImmat(int immat);
	@Query("select e from Etudiant e where e.nom like :x and e.prenom like :y")
	public Etudiant getEtudiantByNomandPrenom(@Param("x") String nomEtudiant,@Param("y") String prenomEtudiant );
	
	@Query("select etudiant from Etudiant etudiant where etudiant.immat like :im")
	public Etudiant getEtudiantById(@Param("im") int  immatEtudiant);
	
	
	@Query("select etudiant from Etudiant etudiant where etudiant.user.username like :im")
	public Etudiant getEtudiantByIdUsername(@Param("im") String username);


}
