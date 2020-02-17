package com.LesAmisDeLEscalade.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.UtilisateurRepository;
import com.LesAmisDeLEscalade.entities.Longueur;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Utilisateur;
import com.LesAmisDeLEscalade.entities.Voie;


@Controller
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private SiteRepository siteRepository;
	
	@RequestMapping(value = "/utilisateur/creer", method = RequestMethod.GET)
	public String creerUtilisateur(Model model) {
		Utilisateur utilisateur = new Utilisateur();
		model.addAttribute("utilisateur", utilisateur);
		return "CreerUtilisateur";
	}

	@RequestMapping(value = "/utilisateur/save", method = RequestMethod.POST)
	public String saveUtilisateur(Model model, @Valid Utilisateur utilisateur, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreerUtilisateur";
		}
		utilisateurRepository.save(utilisateur);
		
		return "redirect:/login";
	}

}
