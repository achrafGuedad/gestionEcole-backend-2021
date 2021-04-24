package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NiveauAnneeScolaire {
    
	@Id
	private int id;
	
	@ManyToOne
	private AnneeScolaire anneescolaire;
	@ManyToOne
	private Niveau niveau;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AnneeScolaire getAnneescolaire() {
		return anneescolaire;
	}
	public void setAnneescolaire(AnneeScolaire anneescolaire) {
		this.anneescolaire = anneescolaire;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	public NiveauAnneeScolaire() {
		super();
		// TODO Auto-generated constructor stub
	}
}
