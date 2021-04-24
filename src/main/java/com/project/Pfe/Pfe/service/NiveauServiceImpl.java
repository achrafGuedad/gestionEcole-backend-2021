package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Pfe.Pfe.dao.NiveauRepository;
import com.project.Pfe.Pfe.entities.Niveau;

@Service
public class NiveauServiceImpl implements NiveauService{

	@Autowired
	private NiveauRepository niveauRepository;
	
	
	public Niveau createNiveau(Niveau niveau) {
		return niveauRepository.save(niveau);
	}

	
	@Override
	public boolean deleteNiveau(int idNiveau) {
        niveauRepository.deleteById(idNiveau);
		return true;
	}


	@Override
	public List<Niveau> getAllNiveau() {
		return niveauRepository.findAll();
	}


	
}
