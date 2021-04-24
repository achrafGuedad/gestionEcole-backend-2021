package com.project.Pfe.Pfe.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {	



/*@Query("select DISTINCT i.classe  from  Inscription i where i.anneeScolaire.idAnneeScolaire like :z")
public List <Inscription> getClasseByAnneScolaire(@Param("z") int annee);*/

@Query("select  i  from  Inscription i where i.etudiant.immat like :immatricule")
public List <Inscription> getInscriptionsEtudiant(@Param("immatricule") int immatricule);

@Query("select  i.etudiant  from  Inscription i where i.classe.idClasse like :idClasse and i.classe.anneeScolaire.idAnneeScolaire like :annee")
public List <Inscription> getEtudiantsByClasseAndAnnee(@Param("idClasse") int idClasse,@Param("annee") int annee );

@Query("select  etd.etudiant  from  Inscription etd where etd.classe.idClasse like :idClasse")
public Page <Etudiant> getStudentsOfClass(@Param("idClasse") int idClasse,Pageable pageable);

@Query("select  COUNT(etd.etudiant)  from  Inscription etd where etd.classe.idClasse like :idClasse")
public int getTotalStudentsOfClass(@Param("idClasse") int idClasse);

@Query("select  i.classe  from  Inscription i where i.etudiant.immat like :immatricule and i.classe.anneeScolaire.idAnneeScolaire like :idYear")
public  Classe getClassOfStudent(@Param("immatricule") int immatricule,@Param("idYear") int idYear);



@Query("select  i  from  Inscription i where i.etudiant.user.username like :username")
public List <Inscription> getInscriptionEtudiantByUsername(@Param("username") String username);
}
