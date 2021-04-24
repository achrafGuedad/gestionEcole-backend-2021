package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class appRole {

	@Id 
	@GeneratedValue
	private int idRole;
	public String roleName;

	public String getRoleName() {
		return roleName;
	}


    
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public appRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
}
