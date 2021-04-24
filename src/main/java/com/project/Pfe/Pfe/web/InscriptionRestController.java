package com.project.Pfe.Pfe.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.dao.InscriptionRepository;
import com.project.Pfe.Pfe.dao.PaiementRepository;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Inscription;
import com.project.Pfe.Pfe.entities.User;

@RestController
@RequestMapping(value="Inscription")
@CrossOrigin("*")
public class InscriptionRestController {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private InscriptionRepository inscritionRepository;

	@Autowired
	private PaiementRepository paiementRepository;
	
	@RequestMapping(value="/ReinscriptionEtudiant/{username}" ,method=RequestMethod.POST)
	public Inscription saveReinscription (@PathVariable("username") String username,@RequestBody Inscription inscription){
		
		//String username=inscription.getEtudiant().getUser().getUsername();
		Etudiant etudiantToFind=etudiantRepository.getEtudiantByIdUsername(username);
	
		inscription.setEtudiant(etudiantToFind);
		paiementRepository.save(inscription.getPaiement());
		return  inscritionRepository.save(inscription);
	}
	
	
	@RequestMapping(value="/getInscriptionByUsername/{username}" ,method=RequestMethod.GET)
	public List <Inscription> getInscriptionByUsername(@PathVariable ("username") String username) {
		
		List<Inscription> listInscription=new ArrayList<Inscription>();
		return listInscription=inscritionRepository.getInscriptionEtudiantByUsername(username);
		
	
	}
	
	
	@RequestMapping(value="/getInscriptionById/{id}" ,method=RequestMethod.GET)
	public Inscription getInscriptionBy(@PathVariable ("id") int idInscription) {
		Inscription inscription;
		return inscription=inscritionRepository.getOne(idInscription);
		
	}
	
	@RequestMapping(value="/modifierInscription/{idInscription}/{idPaiement}" ,method=RequestMethod.PUT)
	public void updateInscription(@PathVariable("idInscription") int idInscription,@PathVariable("idPaiement") int idPaiement,@RequestBody Inscription inscription){
		//inscription.setIdInscription(idInscription);
		inscription.getPaiement().setIdPaiement(idPaiement);
		paiementRepository.save(inscription.getPaiement());
		
		
	}
	
	
}
