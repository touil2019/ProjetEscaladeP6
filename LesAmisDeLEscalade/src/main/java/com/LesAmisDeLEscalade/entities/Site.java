package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Site implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SITE")
	private Long id;
	private String nom;
	private String departement;
	private String ville;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_users")
	 */
	private Users users;
	
	
	
	public Site() {
		super();
		
	}
	
	
	
	public Site(Long id, String nom, String departement, String ville, Users users) {
		super();
		this.id = id;
		this.nom = nom;
		this.departement = departement;
		this.ville = ville;
		this.users = users;
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



	public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}
	
}
