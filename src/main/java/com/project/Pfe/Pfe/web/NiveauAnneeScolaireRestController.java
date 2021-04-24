package com.project.Pfe.Pfe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Pfe.Pfe.entities.Niveau;
import com.project.Pfe.Pfe.entities.NiveauAnneeScolaire;
import com.project.Pfe.Pfe.service.NiveauAnneeScolaireService;

@RestController
@RequestMapping(value="NiveauAnneeScolaire")
@CrossOrigin("*")
public class NiveauAnneeScolaireRestController {
	
	@Autowired
	private NiveauAnneeScolaireService niveauAnneeScolaireService;

	@RequestMapping(value="/create" ,method=RequestMethod.POST)
	public NiveauAnneeScolaire saveNiveauAnneeScolaire(@RequestBody NiveauAnneeScolaire niveauAnneeScolaire){
		return niveauAnneeScolaireService.createNiveauAnneeScolaire(niveauAnneeScolaire);
		
	}
	@RequestMapping(value="/getAll" ,method=RequestMethod.GET)
	public List<NiveauAnneeScolaire> getAllNiveauAnneeScolaire(){
		return niveauAnneeScolaireService.getAllNiveauAnneeScolaire();
		
	}
}
