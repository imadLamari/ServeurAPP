package com.app.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the contract database table.
 * 
 */
@Entity
@NamedQuery(name="Contract.findAll", query="SELECT c FROM Contract c")
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_emission")
	private Date dateEmission;

	@Temporal(TemporalType.DATE)
	@Column(name="date_experation")
	private Date dateExperation;

	@Column(name="type_contarct")
	private String typeContarct;

	@Column(name="type_emission")
	private String typeEmission;

	@Column(name="type_produit")
	private String typeProduit;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="entreprise")
	private Entreprise entrepriseBean;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="emetteur")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Offre
	@OneToMany(mappedBy="contractBean")
	private List<Offre> offres;

	public Contract() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEmission() {
		return this.dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	public Date getDateExperation() {
		return this.dateExperation;
	}

	public void setDateExperation(Date dateExperation) {
		this.dateExperation = dateExperation;
	}

	public String getTypeContarct() {
		return this.typeContarct;
	}

	public void setTypeContarct(String typeContarct) {
		this.typeContarct = typeContarct;
	}

	public String getTypeEmission() {
		return this.typeEmission;
	}

	public void setTypeEmission(String typeEmission) {
		this.typeEmission = typeEmission;
	}

	public String getTypeProduit() {
		return this.typeProduit;
	}

	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}

	public Entreprise getEntrepriseBean() {
		return this.entrepriseBean;
	}

	public void setEntrepriseBean(Entreprise entrepriseBean) {
		this.entrepriseBean = entrepriseBean;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Offre addOffre(Offre offre) {
		getOffres().add(offre);
		offre.setContractBean(this);

		return offre;
	}

	public Offre removeOffre(Offre offre) {
		getOffres().remove(offre);
		offre.setContractBean(null);

		return offre;
	}

}