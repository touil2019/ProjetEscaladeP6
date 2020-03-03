package com.LesAmisDeLEscalade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.ReservationTopo;

@Repository
public interface ReservationTopoRepository extends JpaRepository<ReservationTopo,Long>{
	
	
	  @Query("select r from ReservationTopo r where r.topo.utilisateur.id=:id")
	  public List<ReservationTopo> listeDeRes(@Param("id")
	  Long id);
	 
	/*
	 * @Query("select r from ReservationTopo r where r.topo.utilisateur.id=:id and r.encours=true and r.cloturer=false and r.acceptations=false"
	 * ) public List<ReservationTopo>demandeEnCoursParTopo(@Param("id") Long id);
	 * 
	 * @Query("select r from ReservationTopor where r.topo.utilisateur.id=:id and r.encours=false and r.cloturer=true and r.acceptations=false"
	 * ) public List<ReservationTopo>demandeCloturer(@Param("id") Long id);
	 * 
	 * @Query("select r from ReservationTopo r where r.topo.utilisateur.id=:id and r.encours=false and r.cloturer=false and r.acceptations=true"
	 * ) public List<ReservationTopo>demandeAcceptation(@Param("id") Long id);
	 */
}