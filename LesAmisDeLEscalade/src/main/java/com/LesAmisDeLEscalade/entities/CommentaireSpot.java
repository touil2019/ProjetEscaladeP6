package com.LesAmisDeLEscalade.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class CommentaireSpot implements Serializable{
@Id @GeneratedValue
	private Long id;
	private String commentaire;
	private Date datedeparution;
	public CommentaireSpot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentaireSpot(String commentaire, Date datedeparution) {
		super();
		this.commentaire = commentaire;
		this.datedeparution = datedeparution;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Date getDatedeparution() {
		return datedeparution;
	}
	public void setDatedeparution(Date datedeparution) {
		this.datedeparution = datedeparution;
	}
	
}
