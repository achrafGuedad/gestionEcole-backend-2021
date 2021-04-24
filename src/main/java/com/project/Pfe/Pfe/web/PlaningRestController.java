package com.project.Pfe.Pfe.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Pfe.Pfe.dao.AnneeScolaireRepository;
import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.dao.InscriptionRepository;
import com.project.Pfe.Pfe.dao.PlaningRepository;
import com.project.Pfe.Pfe.dao.UserRepostory;
import com.project.Pfe.Pfe.entities.AnneeScolaire;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Planing;
import com.project.Pfe.Pfe.entities.User;

@RestController
@RequestMapping(value="Plan")
@CrossOrigin("*")
public class PlaningRestController {

	
	@Autowired
	private PlaningRepository planingRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	UserRepostory userRepository;
	
	 @Autowired
	private InscriptionRepository inscriptionRepository;
	
	@Autowired
	private AnneeScolaireRepository anneeScolaireRepository;
	
	
	
	@RequestMapping(value="/getListPlaningByClassId/{idClass}" ,method=RequestMethod.GET)
	public List<Planing> getPlaningOfClass(@PathVariable("idClass") int idClass){
		
		return planingRepository.getListPlaningByClassId(idClass);
	}
	
	
	@RequestMapping(value="/savePlan" ,method=RequestMethod.POST)
	public Planing savePlaning(@RequestBody Planing plan) {
		return planingRepository.save(plan);
	}
	
	
	@RequestMapping(value="/getPlaningByStudent/{username}" ,method=RequestMethod.GET)
	public List<Planing> getPlaningByStudent(@PathVariable("username")String username){
		
		SimpleDateFormat formatter =  new  SimpleDateFormat ( "yyyy" );  
	    Date mydate =  new  Date ();  
	    
	    String dateP=formatter.format (mydate);
	    
	    int integerDateA=Integer.parseInt(formatter.format (mydate))+1;
	    String dateA=String.valueOf(integerDateA);
	    String anneeScolaire=dateP+"-"+dateA;
	    
	    
	    // Etudiant to find
		Etudiant etudiant=etudiantRepository.getEtudiantByIdUsername(username);
		
		// annee scolaire to find 
		AnneeScolaire year=anneeScolaireRepository.getAnneeScolaireByYear(anneeScolaire);
		
		Classe classeToFind=inscriptionRepository.getClassOfStudent(etudiant.getImmat(), year.getIdAnneeScolaire());
		
		
		return planingRepository.getListPlaningByClassId(classeToFind.getIdClasse());
	}
	
	
	
	
	
}
