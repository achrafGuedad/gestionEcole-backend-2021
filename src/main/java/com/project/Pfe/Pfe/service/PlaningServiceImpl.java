package com.project.Pfe.Pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Pfe.Pfe.dao.PlaningRepository;
import com.project.Pfe.Pfe.entities.Planing;

@Service
public class PlaningServiceImpl  implements PlaningService{
	
	@Autowired
	private PlaningRepository planingRepository;

	@Override
	public Planing createPlaning(Planing planing) {
		return planingRepository.save(planing);
	}

}
