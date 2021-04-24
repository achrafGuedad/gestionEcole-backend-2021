package com.project.Pfe.Pfe.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Planing {
	
	@Id
	@GeneratedValue
	private int idPlaning;
	private String jour;
	private String heureDebutSeance;
	private String heurFinSeance;
	
	@ManyToOne
	private Matiere matiere;
	@ManyToOne
	private Salle salle;
	@ManyToOne
    private User prof;
	
	@OneToOne
	private Classe classe;
   
	    
    public Planing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdPlaning() {
		return idPlaning;
	}

	public void setIdPlaning(int idPlaning) {
		this.idPlaning = idPlaning;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getHeureDebutSeance() {
		return heureDebutSeance;
	}

	public void setHeureDebutSeance(String heureDebutSeance) {
		this.heureDebutSeance = heureDebutSeance;
	}

	public String getHeurFinSeance() {
		return heurFinSeance;
	}

	public void setHeurFinSeance(String heurFinSeance) {
		this.heurFinSeance = heurFinSeance;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	

	public User getProf() {
		return prof;
	}

	public void setProf(User prof) {
		this.prof = prof;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}


    
    
       
	

}
