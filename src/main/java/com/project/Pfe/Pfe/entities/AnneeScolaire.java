package com.project.Pfe.Pfe.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AnneeScolaire   {


	@Id
	@GeneratedValue
	private int  idAnneeScolaire;
	private String anneeScolaire;
	
	private String dateDebutSemestre_1;

	private String dateFinSemestre_1;
	
	private String dateDebutSemestre_2;

	private String dateFinSemestre_2;
	

	public AnneeScolaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdAnneeScolaire() {
		return idAnneeScolaire;
	}

	public void setIdAnneeScolaire(int idAnneeScolaire) {
		this.idAnneeScolaire = idAnneeScolaire;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public String getDateDebutSemestre_1() {
		return dateDebutSemestre_1;
	}

	public void setDateDebutSemestre_1(String dateDebutSemestre_1) {
		this.dateDebutSemestre_1 = dateDebutSemestre_1;
	}

	public String getDateFinSemestre_1() {
		return dateFinSemestre_1;
	}

	public void setDateFinSemestre_1(String dateFinSemestre_1) {
		this.dateFinSemestre_1 = dateFinSemestre_1;
	}

	public String getDateDebutSemestre_2() {
		return dateDebutSemestre_2;
	}

	public void setDateDebutSemestre_2(String dateDebutSemestre_2) {
		this.dateDebutSemestre_2 = dateDebutSemestre_2;
	}

	public String getDateFinSemestre_2() {
		return dateFinSemestre_2;
	}

	public void setDateFinSemestre_2(String dateFinSemestre_2) {
		this.dateFinSemestre_2 = dateFinSemestre_2;
	}

	public AnneeScolaire(String anneeScolaire, String dateDebutSemestre_1, String dateFinSemestre_1,
			String dateDebutSemestre_2, String dateFinSemestre_2) {
		super();
		this.anneeScolaire = anneeScolaire;
		this.dateDebutSemestre_1 = dateDebutSemestre_1;
		this.dateFinSemestre_1 = dateFinSemestre_1;
		this.dateDebutSemestre_2 = dateDebutSemestre_2;
		this.dateFinSemestre_2 = dateFinSemestre_2;
	}
	
}
	
	