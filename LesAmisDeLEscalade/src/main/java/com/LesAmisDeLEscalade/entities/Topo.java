package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topo implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private boolean disponible;
	private Date date;
	private String nom;

	public Topo() {
		super();
	}

	public Topo(String nom,String description, boolean disponible, Date date) {
		super();
		this.description = description;
		this.disponible = disponible;
		this.date=date;
		this.nom=nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
