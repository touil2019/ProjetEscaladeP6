package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Longueur implements Serializable {
@Id @GeneratedValue
	private Long id;
	private String nom;
	private int hauteur;
	private String cotation;
	public Longueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Longueur(String nom, int hauteur, String cotation) {
		super();
		this.nom = nom;
		this.hauteur = hauteur;
		this.cotation = cotation;
	}
	public Long getId() {
		return id;
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
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	
}
