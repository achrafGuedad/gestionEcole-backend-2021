package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.AnneeScolaireRepository;
import com.project.Pfe.Pfe.entities.AnneeScolaire;

@Service
public class AnneeScolaireServiceImpl implements AnneeScolaireService  {

	@Autowired
	AnneeScolaireRepository asr;
	
	@Override
	public AnneeScolaire createAnneeScolaire(AnneeScolaire anneeScolaire) {
		return asr.save(anneeScolaire);
		
			}


	@Override
	public List<AnneeScolaire> getAllAnneeScolaire() {
		return asr.findAll();
	}


	@Override
	public AnneeScolaire updateAnneeScolaire(String id_Annee_Scolaire,AnneeScolaire anneeScolaire) {
		anneeScolaire.setAnneeScolaire(id_Annee_Scolaire);
		return asr.save(anneeScolaire);
	}
	
	

	
}
