package com.app.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the entreprise database table.
 * 
 */
@Entity
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="chiffre_affaire")
	private String chiffreAffaire;

	private String effectif;

	private String nom;

	private String secteur;

	@Column(name="site_web")
	private String siteWeb;

	private boolean valide;

	//bi-directional many-to-one association to Contract
	@OneToMany(mappedBy="entrepriseBean")
	private List<Contract> contracts;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="entrepriseBean")
	private List<Utilisateur> utilisateurs;

	public Entreprise() {
	}
	
	

	public Entreprise(String chiffreAffaire, String effectif, String nom, String secteur, String siteWeb,
			boolean valide, List<Contract> contracts, List<Utilisateur> utilisateurs) {
		super();
		this.chiffreAffaire = chiffreAffaire;
		this.effectif = effectif;
		this.nom = nom;
		this.secteur = secteur;
		this.siteWeb = siteWeb;
		this.valide = valide;
		this.contracts = contracts;
		this.utilisateurs = utilisateurs;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChiffreAffaire() {
		return this.chiffreAffaire;
	}

	public void setChiffreAffaire(String chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}

	public String getEffectif() {
		return this.effectif;
	}

	public void setEffectif(String effectif) {
		this.effectif = effectif;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSecteur() {
		return this.secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public String getSiteWeb() {
		return this.siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public boolean getValide() {
		return this.valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public List<Contract> getContracts() {
		return this.contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public Contract addContract(Contract contract) {
		getContracts().add(contract);
		contract.setEntrepriseBean(this);

		return contract;
	}

	public Contract removeContract(Contract contract) {
		getContracts().remove(contract);
		contract.setEntrepriseBean(null);

		return contract;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setEntrepriseBean(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setEntrepriseBean(null);

		return utilisateur;
	}

}