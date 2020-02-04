package com.LesAmisDeLEscalade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Voie;
@Repository
public interface VoieRepository extends JpaRepository<Voie,Long>{
	@Query("select v from Voie v where v.site.id=:id")
	public List<Voie> listeDeVoieParSite(@Param("id") Long id);
	

}