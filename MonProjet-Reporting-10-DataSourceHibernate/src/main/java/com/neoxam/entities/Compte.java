package com.neoxam.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPTES")
public class Compte {

	@Id
	private String numero;
	private String proprietaire;
	private double solde;
	
	public Compte() {
		super();
	}

	public Compte(String numero, String proprietaire, double solde) {
		super();
		this.numero = numero;
		this.proprietaire = proprietaire;
		this.solde = solde;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", proprietaire=" + proprietaire + ", solde=" + solde + "]";
	}

	
}
