package com.LesAmisDeLEscalade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

	 static Utilisateur findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
