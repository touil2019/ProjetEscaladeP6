package com.LesAmisDeLEscalade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Topo;
@Repository
public interface TopoRepository extends JpaRepository<Topo,Long>{

	@Query("select t from Topo t where t.utilisateur.id=:id")
	public List<Topo> listeDeTopoParUsers(@Param("id") Long id);
}