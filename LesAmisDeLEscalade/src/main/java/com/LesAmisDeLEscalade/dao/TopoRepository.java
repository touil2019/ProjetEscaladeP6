package com.LesAmisDeLEscalade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Topo;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Long> {
	/**
	 * requete sql pour une liste de topo par utilisateur par le biais de leurs id
	 * 
	 * @param id
	 * @return
	 */
	@Query("select t from Topo t where t.utilisateur.id=:id")
	public List<Topo> listeDeTopoParUsers(@Param("id") Long id);

	/**
	 * requete pour une liste de topo disponible
	 * 
	 * @return
	 */
	@Query("select t from Topo t where t.disponible=true")
	public List<Topo> listeDeTopoDispo();

}