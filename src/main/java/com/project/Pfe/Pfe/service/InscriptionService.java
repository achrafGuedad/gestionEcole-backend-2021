package com.project.Pfe.Pfe.service;

import java.util.List;

import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Inscription;

public interface InscriptionService {
	
	Inscription createInscription(Inscription inscription);
	void  createReinscription(Inscription inscription);
	public boolean deleteInscription(int idInscription);
	public List<Inscription> getAllInscription();
	
	Etudiant inscription(Etudiant etudiant);

}
