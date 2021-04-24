
package com.project.Pfe.Pfe.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class User {
	
	@Id @GeneratedValue
	private int idUser;
	private String username; 
	//@JsonIgnore
	private String password;
	
	/*@OneToOne
	private Etudiant etudiant;
	@OneToOne
	private  Proffesseur professeur;
	@OneToOne
	private  Secretaire secretaire;
	@OneToOne
	private Surveillant surveillant; */
	
	@ManyToMany(fetch=FetchType.EAGER)
	Collection<appRole> userRoles=new ArrayList<appRole>();
	
	
	public Collection<appRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Collection<appRole> userRoles) {
		this.userRoles = userRoles;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	/*public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Proffesseur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Proffesseur professeur) {
		this.professeur = professeur;
	}
	*/
	

	
	
	
	public User() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	

}
