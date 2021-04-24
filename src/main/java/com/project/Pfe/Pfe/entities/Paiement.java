package com.project.Pfe.Pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paiement {
	
	
	@Id
	@GeneratedValue
	private int idPaiement;
	private Boolean septembre;
	private Boolean octobre;
	private Boolean novembre;
	private Boolean decembre;
	private Boolean janvier;
    private Boolean fevrier;
    private Boolean mars;
    private Boolean avril;
    private Boolean mai;
    private Boolean juin;
    private Boolean juillet;
    private Boolean fraixInscription ;
    
    
    
    public Boolean getFraixInscription() {
		return fraixInscription;
	}



	public void setFraixInscription(Boolean fraixInscription) {
		this.fraixInscription = fraixInscription;
	}



	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getIdPaiement() {
		return idPaiement;
	}



	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}



	public Boolean getSeptembre() {
		return septembre;
	}



	public void setSeptembre(Boolean septembre) {
		this.septembre = septembre;
	}



	public Boolean getOctobre() {
		return octobre;
	}



	public void setOctobre(Boolean octobre) {
		this.octobre = octobre;
	}



	public Boolean getNovembre() {
		return novembre;
	}



	public void setNovembre(Boolean novembre) {
		this.novembre = novembre;
	}



	public Boolean getDecembre() {
		return decembre;
	}



	public void setDecembre(Boolean decembre) {
		this.decembre = decembre;
	}



	public Boolean getJanvier() {
		return janvier;
	}



	public void setJanvier(Boolean janvier) {
		this.janvier = janvier;
	}



	public Boolean getFevrier() {
		return fevrier;
	}



	public void setFevrier(Boolean fevrier) {
		this.fevrier = fevrier;
	}



	public Boolean getMars() {
		return mars;
	}



	public void setMars(Boolean mars) {
		this.mars = mars;
	}



	public Boolean getAvril() {
		return avril;
	}



	public void setAvril(Boolean avril) {
		this.avril = avril;
	}



	public Boolean getMai() {
		return mai;
	}



	public void setMai(Boolean mai) {
		this.mai = mai;
	}



	public Boolean getJuin() {
		return juin;
	}



	public void setJuin(Boolean juin) {
		this.juin = juin;
	}



	public Boolean getJuillet() {
		return juillet;
	}



	public void setJuillet(Boolean juillet) {
		this.juillet = juillet;
	}
}
