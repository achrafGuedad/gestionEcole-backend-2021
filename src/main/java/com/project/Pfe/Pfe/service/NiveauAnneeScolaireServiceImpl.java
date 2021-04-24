package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.NiveauAnneeScolaireRepository;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.NiveauAnneeScolaire;

@Service
public class NiveauAnneeScolaireServiceImpl implements NiveauAnneeScolaireService {
    
	
	@Autowired
	private NiveauAnneeScolaireRepository niveauAnneeScolaireRepository;
	
	@Override
	public NiveauAnneeScolaire createNiveauAnneeScolaire(NiveauAnneeScolaire niveauAnneeScolaire) {
		return niveauAnneeScolaireRepository.save(niveauAnneeScolaire);
	}

	@Override
	public List<NiveauAnneeScolaire> getAllNiveauAnneeScolaire() {
		return niveauAnneeScolaireRepository.findAll();
	}

}
