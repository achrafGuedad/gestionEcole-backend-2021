package com.project.Pfe.Pfe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Etudiant {

	@Id @GeneratedValue
	private int immat;
	private String nom;
	private String prenom;
	private String email;
	private String numTel;
	@OneToOne
	private User user;
	
	/*@OneToMany(mappedBy="etudiant",fetch=FetchType.EAGER)
	private List<Inscription> listMatieres=new ArrayList<Inscription>();
 
 */

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	
	public List<Inscription> getGetInscription() {
		return getInscription;
	}



	public void setGetInscription(List<Inscription> getInscription) {
		this.getInscription = getInscription;
	}*/



	
	
	public String getNom() {
		return nom;
	}
	

	public int getImmat() {
		return immat;
	}

	public void setImmat(int immat) {
		this.immat = immat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	
	
	
}
