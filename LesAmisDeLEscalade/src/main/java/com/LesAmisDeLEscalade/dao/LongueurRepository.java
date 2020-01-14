package com.LesAmisDeLEscalade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Longueur;
@Repository
public interface LongueurRepository extends JpaRepository<Longueur,Long> {

}
