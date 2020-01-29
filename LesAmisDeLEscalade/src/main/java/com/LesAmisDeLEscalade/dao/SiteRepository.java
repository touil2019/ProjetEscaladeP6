package com.LesAmisDeLEscalade.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Site;

@Repository
public interface SiteRepository extends JpaRepository <Site,Long> {

	  @Query("select s from Site s where s.nom like :x") 
	  
	  public Page<Site> chercher (@Param("x") String mc,Pageable pageable);
	 
	

}
