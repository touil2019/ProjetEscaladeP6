package com.LesAmisDeLEscalade.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
	/**
	 * requete sql pour une recherche par mot cle
	 * 
	 * @param mc
	 * @param pageable
	 * @return
	 */
	@Query("select s from Site s  where lower(s.nom) like lower(concat('%', :x,'%'))"
			+ " or lower(s.ville)  like lower(concat('%', :x,'%')) "
			+ "or lower(s.departement)  like lower(concat('%', :x,'%'))" + " or lower(s.secteur)  like lower(concat('%', :x,'%')) " +" or lower(s.cotation)  like lower(concat('%', :x,'%')) ")
	public Page<Site> chercher(@Param("x") String mc, Pageable pageable);

	/**
	 * requete sql pour une liste de site ordonnée par id
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select s from Site s order by s.id asc")
	public Page<Site> listSite(Pageable pageable);

}