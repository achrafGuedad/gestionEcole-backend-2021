package com.project.Pfe.Pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.ProffesseurRepository;
import com.project.Pfe.Pfe.entities.Proffesseur;

@Service
public class ProffesseurServiceImpl  implements ProffesseurService{
	
	@Autowired
	private ProffesseurRepository proffesseurRepository;

	@Override
	public Proffesseur createProffesseur(Proffesseur prof) {
		return proffesseurRepository.save(prof);
	}

}
