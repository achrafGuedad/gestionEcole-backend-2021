package com.project.Pfe.Pfe.service;

import java.util.List;

import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.NiveauAnneeScolaire;

public interface NiveauAnneeScolaireService {
	
	NiveauAnneeScolaire createNiveauAnneeScolaire(NiveauAnneeScolaire niveauAnneeScolaire);
	List<NiveauAnneeScolaire>  getAllNiveauAnneeScolaire();
	//Classe updateNiveauAnneeScolaire(int id_classe,Classe classe);

}
