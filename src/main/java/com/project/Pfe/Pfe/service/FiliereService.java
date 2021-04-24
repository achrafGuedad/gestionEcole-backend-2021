package com.project.Pfe.Pfe.service;

import java.util.List;

import com.project.Pfe.Pfe.entities.Filiere;

public interface FiliereService {

	public Filiere createFiliere(Filiere filiere);
	public List<Filiere> getAllFiliere();
    public boolean deleteFiliere(int idNiveau);
    
	
	

}
