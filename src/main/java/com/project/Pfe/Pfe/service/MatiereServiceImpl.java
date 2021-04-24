package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.MatiereRepository;
import com.project.Pfe.Pfe.entities.Matiere;

@Service
public class MatiereServiceImpl implements MatiereService{
	
	@Autowired
	private MatiereRepository matiereRepository;

	@Override
	public Matiere createMatiere(Matiere matiere) {
		return matiereRepository.save(matiere);
	}

	@Override
	public boolean deleteMatiere(int idMatiere) {
	 matiereRepository.deleteById(idMatiere);
		return true;
	}

	@Override
	public List<Matiere> getAllMatiere() {
		return matiereRepository.findAll();
	}

}
