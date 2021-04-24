package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Papier {

	@Id
	@GeneratedValue
	private int idPapier;
	
	private String libelle;

	public int getIdPapier() {
		return idPapier;
	}

	public void setIdPapier(int idPapier) {
		this.idPapier = idPapier;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Papier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
