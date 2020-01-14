package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Site implements Serializable {
@Id @GeneratedValue
@Column(name="ID_SITE")
	private Long id;
	private String nom;
	private String departement;
	private String ville;
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Site(String nom, String departement, String ville) {
		super();
		this.nom = nom;
		this.departement = departement;
		this.ville = ville;
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
	
}
