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
	  public List<ReservationTopo> listeDeReservationRecuesParUsers(@Param("id")
	  Long id);
	 
}