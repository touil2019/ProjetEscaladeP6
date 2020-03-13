package com.LesAmisDeLEscalade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Longueur;
@Repository
public interface LongueurRepository extends JpaRepository<Longueur,Long> {
	/**
	 * requete pour une liste de longueur par site par voie lier à l id du site
	 * @param id
	 * @return
	 */
	@Query("select l from Longueur l where l.voie.site.id=:id")
	public List<Longueur> listeDeLongueurParSite(@Param("id") Long id);
	
	
}
