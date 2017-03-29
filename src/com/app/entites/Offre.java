package com.app.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the offre database table.
 * 
 */
@Entity
@NamedQuery(name="Offre.findAll", query="SELECT o FROM Offre o")
public class Offre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_offre")
	private Date dateOffre;

	@Temporal(TemporalType.DATE)
	@Column(name="date_validation")
	private Date dateValidation;

	private String etat;

	@Column(name="mode_negociation")
	private String modeNegociation;

	private float prix;

	private double quantite;

	@Column(name="type_offre")
	private String typeOffre;

	private boolean valide;

	//bi-directional many-to-one association to Contract
	@ManyToOne
	@JoinColumn(name="contract")
	private Contract contractBean;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="recepteur")
	private Utilisateur utilisateur;

	public Offre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOffre() {
		return this.dateOffre;
	}

	public void setDateOffre(Date dateOffre) {
		this.dateOffre = dateOffre;
	}

	public Date getDateValidation() {
		return this.dateValidation;
	}

	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getModeNegociation() {
		return this.modeNegociation;
	}

	public void setModeNegociation(String modeNegociation) {
		this.modeNegociation = modeNegociation;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public double getQuantite() {
		return this.quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public String getTypeOffre() {
		return this.typeOffre;
	}

	public void setTypeOffre(String typeOffre) {
		this.typeOffre = typeOffre;
	}

	public boolean getValide() {
		return this.valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Contract getContractBean() {
		return this.contractBean;
	}

	public void setContractBean(Contract contractBean) {
		this.contractBean = contractBean;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}