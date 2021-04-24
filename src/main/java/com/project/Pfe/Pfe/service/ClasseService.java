package com.project.Pfe.Pfe.service;

import java.util.List;

import com.project.Pfe.Pfe.entities.Classe;

public interface ClasseService {
	
	Classe createClasse(Classe classe);
	List<Classe>  getAllClasse();
	Classe updateClasse(int id_classe,Classe classe);
	
}
