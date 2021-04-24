package com.project.Pfe.Pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.SalleRepository;
import com.project.Pfe.Pfe.entities.Salle;

@Service
public class SalleServiceImpl  implements SalleService {
	
	@Autowired
	private SalleRepository salleRepository;

	@Override
	public Salle createSalle(Salle salle) {
		return salleRepository.save(salle);
	}

}
