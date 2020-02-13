package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String contenu;
	private Date datedeparution;

	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	
	
	public Commentaire() {
		super();
		
	}

	public Commentaire(String contenu, Date datedeparution) {
		super();
		this.contenu =  contenu;
		this.datedeparution = datedeparution;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDatedeparution() {
		return datedeparution;
	}

	public void setDatedeparution(Date datedeparution) {
		this.datedeparution = datedeparution;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

		
}
