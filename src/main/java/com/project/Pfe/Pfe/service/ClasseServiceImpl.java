package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.ClasseRepository;
import com.project.Pfe.Pfe.entities.Classe;

@Service
public class ClasseServiceImpl implements ClasseService {

	@Autowired
	private ClasseRepository classeRepository;
	
	@Override
	public Classe createClasse(Classe classe) {
		return classeRepository.save(classe);
	}

	@Override
	public List<Classe> getAllClasse() {
		return classeRepository.findAll();
	}

	@Override
	public Classe updateClasse(int id_classe,Classe classe) {
	// in here we have to call the  uncreated method ,by using  the annotation @Query
		return null;
		
	}

	

	

}
