package com.app.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String login;

	private String nom;

	private String password;

	private String prenom;

	private String role;

	private boolean valide;

	//bi-directional many-to-one association to Contract
	@OneToMany(mappedBy="utilisateur")
	private List<Contract> contracts;

	//bi-directional many-to-one association to Offre
	@OneToMany(mappedBy="utilisateur")
	private List<Offre> offres;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="entreprise")
	private Entreprise entrepriseBean;

	public Utilisateur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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
		contract.setUtilisateur(this);

		return contract;
	}

	public Contract removeContract(Contract contract) {
		getContracts().remove(contract);
		contract.setUtilisateur(null);

		return contract;
	}

	public List<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Offre addOffre(Offre offre) {
		getOffres().add(offre);
		offre.setUtilisateur(this);

		return offre;
	}

	public Offre removeOffre(Offre offre) {
		getOffres().remove(offre);
		offre.setUtilisateur(null);

		return offre;
	}

	public Entreprise getEntrepriseBean() {
		return this.entrepriseBean;
	}

	public void setEntrepriseBean(Entreprise entrepriseBean) {
		this.entrepriseBean = entrepriseBean;
	}

}