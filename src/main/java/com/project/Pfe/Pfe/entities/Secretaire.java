package com.project.Pfe.Pfe.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Secretaire {

	@Id
	@GeneratedValue
	private int idSecretaire;
	private String nom;
	private String prenom;
	private String numTel;
	private String e_mail;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	
	public Secretaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdSecretaire() {
		return idSecretaire;
	}
	public void setIdSecretaire(int idSecretaire) {
		this.idSecretaire = idSecretaire;
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
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
