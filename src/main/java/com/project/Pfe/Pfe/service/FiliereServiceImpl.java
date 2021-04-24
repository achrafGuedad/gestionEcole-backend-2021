package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.FiliereRepository;
import com.project.Pfe.Pfe.entities.Filiere;

@Service
public class FiliereServiceImpl implements FiliereService{

	@Autowired
	private FiliereRepository filiereRepository;
	
	@Override
	public Filiere createFiliere(Filiere filiere) {
		
		return filiereRepository.save(filiere);
	}

	@Override
	public List<Filiere> getAllFiliere() {
		return filiereRepository.findAll();
	}

	@Override
	public boolean deleteFiliere(int codeFiliere) {
		filiereRepository.deleteById(codeFiliere);
		return true;
	}
   

	

	

}
