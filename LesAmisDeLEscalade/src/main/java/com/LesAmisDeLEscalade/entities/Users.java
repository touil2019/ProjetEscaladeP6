package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Users implements Serializable{
	@Id	
	@GeneratedValue
	@Column(name="ID_Users")
	private Long id;
	private String pseudo;
	private String nomdestinataire;
	private int numadherent;
	private String voie;
	private String complementlocalisation;
	private String localite;
	
	
	/*
	 * @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL) private Collection<Site>sites;
	 */
	
	public Users() {
		super();
		
	}


	public Users(Long id, String pseudo, String nomdestinataire, int numadherent, String voie,
			String complementlocalisation, String localite) {
		super();
		this.id=id;
		this.pseudo = pseudo;
		this.nomdestinataire = nomdestinataire;
		this.numadherent = numadherent;
		this.voie = voie;
		this.complementlocalisation = complementlocalisation;
		this.localite = localite;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getNomdestinataire() {
		return nomdestinataire;
	}


	public void setNomdestinataire(String nomdestinataire) {
		this.nomdestinataire = nomdestinataire;
	}


	public int getNumadherent() {
		return numadherent;
	}


	public void setNumadherent(int numadherent) {
		this.numadherent = numadherent;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getComplementlocalisation() {
		return complementlocalisation;
	}


	public void setComplementlocalisation(String complementlocalisation) {
		this.complementlocalisation = complementlocalisation;
	}


	public String getLocalite() {
		return localite;
	}


	public void setLocalite(String localite) {
		this.localite = localite;
	}

}
