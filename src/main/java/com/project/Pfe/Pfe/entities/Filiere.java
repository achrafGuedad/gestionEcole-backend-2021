package com.project.Pfe.Pfe.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Filiere {

	@Id @GeneratedValue
	private int codeFiliere;
	private String libelle;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateCreation;
	
	
    @OneToMany(mappedBy="filiere")
	private List<Niveau> Niveaux =new ArrayList<Niveau>();

    @JsonIgnore
	public List<Niveau> getNiveaux() {
		return Niveaux;
	}

	public void setNiveaux(List<Niveau> niveaux) {
		Niveaux = niveaux;
	}

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filiere(String libelle, LocalDate dateCreation) {
		super();
		this.libelle = libelle;
		this.dateCreation = dateCreation;
	}

	public int getCodeFiliere() {
		return codeFiliere;
	}

	public void setCodeFiliere(int codeFiliere) {
		this.codeFiliere = codeFiliere;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
}
