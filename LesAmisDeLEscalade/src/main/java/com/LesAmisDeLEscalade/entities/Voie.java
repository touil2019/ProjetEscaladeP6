package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Voie implements Serializable{
@Id @GeneratedValue
@Column(name="ID_VOIE")
	private Long id;
	private String cotation;
	private int hauteur;
	private String nom;
	public Voie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voie(String cotation, int hauteur, String nom) {
		super();
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
