package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class ReservationTopo implements Serializable {
@Id @GeneratedValue
	private Long id;
	private Date dateemprunt;
	private boolean encours;
	private boolean acceptations;
	
	@ManyToOne
	@JoinColumn(name = "ID_SITE")
	private Site site;
	
	@OneToOne
	@JoinColumn(name = "id_topo")
	private Topo topo;
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	public ReservationTopo() {
		super();
		
	}
	public ReservationTopo(Date dateemprunt, boolean encours, boolean acceptations) {
		super();
		this.dateemprunt = dateemprunt;
		this.encours = encours;
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
	public boolean isEncours() {
		return encours;
	}
	public void setEncours(boolean encours) {
		this.encours = encours;
	}
	public boolean isAcceptations() {
		return acceptations;
	}
	public void setAcceptations(boolean acceptations) {
		this.acceptations = acceptations;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
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
