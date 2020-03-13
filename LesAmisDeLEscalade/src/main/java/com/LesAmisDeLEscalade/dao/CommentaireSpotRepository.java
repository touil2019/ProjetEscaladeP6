package com.LesAmisDeLEscalade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Commentaire;


@Repository
public interface CommentaireSpotRepository extends JpaRepository<Commentaire,Long> {
	/**
	 * requete pour un commentaire lier à un site par l id
	 * @param id
	 * @return
	 */
	@Query("select c from Commentaire c where c.site.id=:id")
	public List<Commentaire> listeDeCommentaireParSite(@Param("id") Long id);

}