package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Controle {

	@Id 
	@GeneratedValue
	private int idControle;
	
	@ManyToOne
	private Etudiant etudiant;
	
	@ManyToOne
	private Classe classe;
	
	@ManyToOne
	private Matiere matiere;
	
	
	private String prof;
	
	private int numeroControle;
	
	private double note;

	public Controle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdControle() {
		return idControle;
	}

	public void setIdControle(int idControle) {
		this.idControle = idControle;
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

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public int getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(int numeroControle) {
		this.numeroControle = numeroControle;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
}
