package com.project.Pfe.Pfe.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inscription {
	
	@Id
	@GeneratedValue
	private int idInscription;
	@ManyToOne
	private Classe classe;
	
	@ManyToOne
    private Etudiant  etudiant;
	
	@ManyToOne
    private Paiement paiement;
	
	
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	public int getIdInscription() {
		return idInscription;
	}
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	

}
