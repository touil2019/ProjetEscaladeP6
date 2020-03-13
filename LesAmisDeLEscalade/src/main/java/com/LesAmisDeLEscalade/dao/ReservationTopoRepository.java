package com.LesAmisDeLEscalade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.ReservationTopo;

@Repository
public interface ReservationTopoRepository extends JpaRepository<ReservationTopo, Long> {

	/**
	 * requete pour une liste de reservation recue pour le topo lier à un
	 * utilisateur par l id
	 * 
	 * @param id
	 * @return
	 */
	@Query("select r from ReservationTopo r where r.topo.utilisateur.id=:id")
	public List<ReservationTopo> listeDeResaReçues(@Param("id") Long id);

	/**
	 * 
	 * requete pour une liste de reservation emise lier a l id de l utilisateur
	 * 
	 * @param id
	 * @return
	 */
	@Query("select r from ReservationTopo r where r.utilisateur.id=:id")
	public List<ReservationTopo> listeDeResaEmises(@Param("id") Long id);

}