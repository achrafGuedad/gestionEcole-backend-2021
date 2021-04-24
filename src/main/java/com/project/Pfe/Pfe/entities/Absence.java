package com.project.Pfe.Pfe.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Absence {
	
	@Id
	@GeneratedValue
	private int idAbsence;
	@ManyToOne
	private Classe classe;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Matiere matiere;
	
	
	private String jourAbsence;
	
    private String heureDeppartAbsence;
	 
	private String heureFinAbsene;
	
	private String prof;
	
	
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public int getIdAbsence() {
		return idAbsence;
	}
	
	public void setIdAbsence(int idAbsence) {
		this.idAbsence = idAbsence;
	}
	public String getJourAbsence() {
		return jourAbsence;
	}
	public void setJourAbsence(String jourAbsence) {
		this.jourAbsence = jourAbsence;
	}
	public String getHeureDeppartAbsence() {
		return heureDeppartAbsence;
	}
	public void setHeureDeppartAbsence(String heureDeppartAbsence) {
		this.heureDeppartAbsence = heureDeppartAbsence;
	}
	public String getHeureFinAbsene() {
		return heureFinAbsene;
	}
	public void setHeureFinAbsene(String heureFinAbsene) {
		this.heureFinAbsene = heureFinAbsene;
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
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	

}
