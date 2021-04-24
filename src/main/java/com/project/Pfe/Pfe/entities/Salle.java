package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Salle {
	
	@Id 
	@GeneratedValue
	private int idSalle;
	private String libelle;
	private String localisation;
	
	
	public int getIdSalle() {
		return idSalle;
	}


	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}

}
