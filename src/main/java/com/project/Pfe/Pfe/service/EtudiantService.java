package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.entities.Etudiant;


public interface EtudiantService {
	
	
	 List<Etudiant> getAll();
	 //public Etudiant getEtudiantByImmat(int immat);
	 Etudiant ajouterEtudiant(Etudiant etudiant);
	 void deleteEtudiant(int immat);

}
