package com.project.Pfe.Pfe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Pfe.Pfe.dao.AnneeScolaireRepository;
import com.project.Pfe.Pfe.entities.AnneeScolaire;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.service.AnneeScolaireService;

@RestController
@RequestMapping(value="AnneeScolaire")
@CrossOrigin("*")
public class AnneeScolaireRestController {
    
	@Autowired
    AnneeScolaireService ass;
	
	@Autowired
	AnneeScolaireRepository anneeScolaireRepository;
	
	
	@RequestMapping(value="/create" ,method=RequestMethod.POST)
	public AnneeScolaire createAnneeScolaire(@RequestBody AnneeScolaire anneeScolaire){
		return ass.createAnneeScolaire(anneeScolaire);
			}
	
	@RequestMapping(value="/getAll" ,method=RequestMethod.GET)
	public List<AnneeScolaire> getAllAnneeScolaire(){
		return ass.getAllAnneeScolaire();
			}
	
	@RequestMapping(value="/getAnneeScolaireByAnnee/{annee}" ,method=RequestMethod.GET)
	public AnneeScolaire getAnneeScolaireByAnnee(@PathVariable int annee){
		AnneeScolaire anneeScolaire=anneeScolaireRepository.getAnneeScolaireById(annee);
				return anneeScolaire;
			}
	
	@RequestMapping(value="/modifierAnneeScolaire/{id}" ,method=RequestMethod.PUT)
	public AnneeScolaire updateAnneeScolaire(@PathVariable int id,@RequestBody AnneeScolaire anneeScolaire ){
		
		anneeScolaire.setIdAnneeScolaire(id);
		return ass.createAnneeScolaire(anneeScolaire);
		
		
	}
	
	
	
}
