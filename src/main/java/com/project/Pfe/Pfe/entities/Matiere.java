package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.Pfe.Pfe.entities.Niveau;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Matiere {
	
	@Id 
	@GeneratedValue
	private int idMatiere;
	private String libelle;
	private double coeffitien;
	@ManyToOne
	private Niveau niveau;
	
	private int idSemestre;
	
	
	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Matiere(String libelle, double coeffitien, Niveau niveau) {
		super();
		this.libelle = libelle;
		this.coeffitien = coeffitien;
		this.niveau = niveau;
	}
	
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getCoeffitien() {
		return coeffitien;
	}
	public void setCoeffitien(double coeffitien) {
		this.coeffitien = coeffitien;
	}

}
