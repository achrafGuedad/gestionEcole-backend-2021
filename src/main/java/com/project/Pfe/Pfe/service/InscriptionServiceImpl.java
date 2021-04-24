package com.project.Pfe.Pfe.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.Pfe.Pfe.dao.ClasseRepository;
import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.dao.InscriptionRepository;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Inscription;
import com.project.Pfe.Pfe.entities.User;

@Service 
public class InscriptionServiceImpl  implements InscriptionService{
	
	@PersistenceContext
	EntityManager em;
	
	 @Autowired
	private EtudiantService etudiantService;
	 
	 @Autowired
	 EtudiantRepository etudiantRepository;
	 
	 @Autowired
	 ClasseRepository classeRepository;
	 
	 @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	

    @Autowired	
	private  InscriptionRepository inscriptionRepository; 
	  
    User user=new User();
    Etudiant etudiant=new Etudiant();
    
    
    @Override
   	public Inscription createInscription(Inscription inscription) {
		 return inscriptionRepository.save(inscription);
		 
    }
    
    
   	

	@Override
	public boolean deleteInscription(int idInscription) {
		inscriptionRepository.deleteById(idInscription);
		return true;
	}

	@Override
	public List<Inscription> getAllInscription() {
		return inscriptionRepository.findAll();
	}




	@Override
	public void createReinscription(Inscription inscription) {
		 em.persist(inscription);
	}




	@Override
	public Etudiant inscription(Etudiant etudiant) {
	
		
		 String passwordEncoded=bCryptPasswordEncoder.encode(etudiant.getUser().getPassword());
		 etudiant.getUser().setPassword(passwordEncoded);
		 
		  
		return etudiantService.ajouterEtudiant(etudiant);
			
	}

/*@Override
	public Inscription inscription(Etudiant etudiant, Classe classe) {
		
		Classe classeToFind=new Classe();
		classeToFind=classeRepository.getClasseById(classe.getIdClasse());
		
		//Etudiant etudiantToFind=new Etudiant();
		//etudiantToFind=etudiantRepository.getEtudiantById(etudiant.getImmat());
		
		 String passwordEncoded=bCryptPasswordEncoder.encode(etudiant.getUser().getPassword());
		 etudiant.getUser().setPassword(passwordEncoded);
		 
		  
		etudiantService.ajouterEtudiant(etudiant);
		
		Inscription ins=new Inscription();
		ins.setEtudiant(etudiant);
		ins.setClasse(classeToFind);
		inscriptionRepository.save(ins);
		
		
	
			return ins;
	}
*/


	

}
