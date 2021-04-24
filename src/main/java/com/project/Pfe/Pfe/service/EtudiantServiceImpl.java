package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.entities.Etudiant;

@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	EtudiantRepository etudiantR;
	
	@Override
	public List<Etudiant> getAll() {
		
		return etudiantR.findAll();
	}

	@Override
	public Etudiant ajouterEtudiant(Etudiant etudiant) {
		return etudiantR.save(etudiant);
	}

	@Override
	public void deleteEtudiant(int immat) {
		etudiantR.deleteById(immat);		
		
	}

	

	



	


	
	
	

	

	

	

}
