package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Topo implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private boolean disponible;
	private Date date;
	private String nom;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	@OneToMany
	(mappedBy = "topo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<ReservationTopo> reservations;
	

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



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Collection<ReservationTopo> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<ReservationTopo> reservations) {
		this.reservations = reservations;
	}


}
