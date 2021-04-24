package com.project.Pfe.Pfe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Niveau {
	
	@Id @GeneratedValue
	private int idNiveau;
	
	private String libelle;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Filiere filiere;
	
	@OneToMany(mappedBy="niveau")
	private List<Matiere> listMatieres=new ArrayList<Matiere>();
	
	
	
	@JsonIgnore
	public List<Matiere> getListMatieres() {
		return listMatieres;
	}



	public void setListMatieres(List<Matiere> listMatieres) {
		this.listMatieres = listMatieres;
	}



	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	

	public Niveau() { }

	public Niveau(String libelle, Filiere filiere) {
		super();
		this.libelle = libelle;
		this.filiere = filiere;
	}

	

	public int getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFliere(Filiere filiere) {
		this.filiere = filiere;
	}

}
