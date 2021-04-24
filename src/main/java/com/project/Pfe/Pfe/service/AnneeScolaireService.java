package com.project.Pfe.Pfe.service;

import java.util.List;

import com.project.Pfe.Pfe.entities.AnneeScolaire;



public interface AnneeScolaireService {

	AnneeScolaire createAnneeScolaire(AnneeScolaire anneeScolaire);
	List<AnneeScolaire>  getAllAnneeScolaire();
	AnneeScolaire updateAnneeScolaire(String id_Annee_Scolaire,AnneeScolaire anneeScolaire);
}
