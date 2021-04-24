package com.project.Pfe.Pfe.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Proffesseur {
	
	@Id
	@GeneratedValue
	private int idProffesseur;
	private String nom;
	private String prenom;
	private String numTEl;
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	public Proffesseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdProffesseur() {
		return idProffesseur;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setIdProffesseur(int idProffesseur) {
		this.idProffesseur = idProffesseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumTEl() {
		return numTEl;
	}
	public void setNumTEl(String numTEl) {
		this.numTEl = numTEl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
