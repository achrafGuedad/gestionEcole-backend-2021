package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DemandePapier {
	
	@Id
	@GeneratedValue
	private int idDemandePapier;
	
	@ManyToOne
	private Papier papier;
	
	@ManyToOne
	private Etudiant etudiant;
	
	private String dateDemande;
	
	private String Etat;
	
	public DemandePapier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDemandePapier() {
		return idDemandePapier;
	}

	public void setIdDemandePapier(int idDemandePapier) {
		this.idDemandePapier = idDemandePapier;
	}

	public Papier getPapier() {
		return papier;
	}

	public void setPapier(Papier papier) {
		this.papier = papier;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public String getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	

}
