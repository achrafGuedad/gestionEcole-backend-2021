package com.project.Pfe.Pfe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.Pfe.Pfe.entities.Niveau;

public interface NiveauService {
	
	public Niveau createNiveau(Niveau niveau);
	public boolean deleteNiveau(int idNiveau );
	public List<Niveau> getAllNiveau();

}
