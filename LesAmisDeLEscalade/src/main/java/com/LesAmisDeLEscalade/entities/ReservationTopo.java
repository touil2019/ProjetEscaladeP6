package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ReservationTopo implements Serializable {
@Id @GeneratedValue
	private Long id;
	private Date dateemprunt;
	private boolean acceptations;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_topo")
	private Topo topo;
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	public ReservationTopo() {
		super();
		
	}
	
	public ReservationTopo(Date dateemprunt, boolean encours, boolean acceptations,boolean cloturer) {
		this.dateemprunt = dateemprunt;
		this.acceptations = acceptations;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateemprunt() {
		return dateemprunt;
	}
	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}
	
	public boolean isAcceptations() {
		return acceptations;
	}
	public void setAcceptations(boolean acceptations) {
		this.acceptations = acceptations;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
