package com.LesAmisDeLEscalade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.LesAmisDeLEscalade.entities.Commentaire;

@Repository
public interface CommentaireSpotRepository extends JpaRepository<Commentaire,Long> {

}