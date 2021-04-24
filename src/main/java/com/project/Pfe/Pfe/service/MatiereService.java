package com.project.Pfe.Pfe.service;

import java.util.List;

import com.project.Pfe.Pfe.entities.Matiere;

public interface MatiereService {
	
	public Matiere createMatiere(Matiere matiere);
	public boolean deleteMatiere(int idMatiere);
	public List<Matiere> getAllMatiere();
	//public List<Matiere>getlisteMatiere();
	

}
