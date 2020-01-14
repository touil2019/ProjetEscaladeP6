package com.LesAmisDeLEscalade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.ReservationTopo;
@Repository
public interface ReservationTopoRepository extends JpaRepository<ReservationTopo,Long>{

}
