package com.app.entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the information database table.
 * 
 */
@Entity
@NamedQuery(name="Information.findAll", query="SELECT i FROM Information i")
public class Information implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descriptif;

	private int entreprise;

	private String type;

	private int utilisateur;

	public Information() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptif() {
		return this.descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public int getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(int entreprise) {
		this.entreprise = entreprise;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(int utilisateur) {
		this.utilisateur = utilisateur;
	}

}