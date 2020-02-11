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

@Entity
public class Voie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VOIE")
	private Long id;
	private String secteur;
	private String cotation;
	private int hauteur;
	private String nom;

	@ManyToOne
	@JoinColumn(name = "ID_SITE")
	private Site site;

	@OneToMany(mappedBy = "voie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Longueur> longueur;

	public Voie() {
		super();
		
	}

	public Voie(String secteur, String cotation, int hauteur, String nom) {
		super();
		this.secteur = secteur;
		this.cotation = cotation;
		this.hauteur = hauteur;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Collection<Longueur> getLongueur() {
		return longueur;
	}

	public void setLongueur(Collection<Longueur> longueur) {
		this.longueur = longueur;
	}

}
