package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Site implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SITE")
	private Long id;
	private String nom;
	private String departement;
	private String ville;

		
	@OneToMany
	(mappedBy = "site", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Topo> topos;
	
	@OneToMany(mappedBy = "site", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Voie> voies;
	
	@OneToMany(mappedBy = "site", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Longueur> longueur;
		


	public Site() {
		super();

	}

	public Site(String nom, String departement, String ville) {
		this.nom = nom;
		this.departement = departement;
		this.ville = ville;
	}

	public Long getId() {
		return id;
	}

	public Collection<Voie> getVoies() {
		return voies;
	}

	public void setVoies(Collection<Voie> voies) {
		this.voies = voies;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Utilisateur getUsers() {
		return users;
	}

	public void setUsers(Utilisateur users) {
		this.users = users;
	}

}
