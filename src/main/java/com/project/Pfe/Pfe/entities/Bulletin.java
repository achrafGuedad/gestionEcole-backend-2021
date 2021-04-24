package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bulletin {

	@Id
	@GeneratedValue
	private int idBulletin;
	 
	@ManyToOne
	private Matiere  matiere;
	
	@ManyToOne
	private Etudiant etudiant;
	
	@ManyToOne
	private Classe classe;
	
	private double notefinaleMatiere;

	
	public Matiere getMatiere() {
		return matiere;
	}



	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}



	public Etudiant getEtudiant() {
		return etudiant;
	}



	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}



	public Classe getClasse() {
		return classe;
	}



	public void setClasse(Classe classe) {
		this.classe = classe;
	}



	public double getNotefinaleMatiere() {
		return notefinaleMatiere;
	}



	public void setNotefinaleMatiere(double notefinaleMatiere) {
		this.notefinaleMatiere = notefinaleMatiere;
	}



	public void setIdBulletin(int idBulletin) {
		this.idBulletin = idBulletin;
	}



	public Bulletin( Etudiant etudiant, Classe classe, double notefinaleMatiere) {
		super();
		//this.matiere = matiere;
		this.etudiant = etudiant;
		this.classe = classe;
		this.notefinaleMatiere = notefinaleMatiere;
	}



	public int getIdBulletin() {
		return idBulletin;
	}

	

	public Bulletin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
