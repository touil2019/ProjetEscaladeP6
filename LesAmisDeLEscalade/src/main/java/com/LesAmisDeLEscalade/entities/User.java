package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class User implements Serializable{
@Id @GeneratedValue
	private Long id;
	private String pseudo;
	private String nomdestinataire;
	private int numadherent;
	private String voie;
	private String complementlocalisation;
	private String localite;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String pseudo, String nomdestinataire, int numadherent, String voie, String complementlocalisation,
			String localite) {
		super();
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
	public void setLocalité(String localite) {
		this.localite = localite;
	}
	

}
