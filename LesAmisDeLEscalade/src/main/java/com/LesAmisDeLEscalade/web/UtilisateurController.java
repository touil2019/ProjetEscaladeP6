package com.LesAmisDeLEscalade.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LesAmisDeLEscalade.dao.TopoRepository;
import com.LesAmisDeLEscalade.dao.UtilisateurRepository;
import com.LesAmisDeLEscalade.entities.Topo;
import com.LesAmisDeLEscalade.entities.Utilisateur;

@Controller
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private TopoRepository topoRepository;

	/**
	 * formulaire de creation d un nouvelle utilisateur
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/utilisateur/creer", method = RequestMethod.GET)
	public String creerUtilisateur(Model model) {
		Utilisateur utilisateur = new Utilisateur();
		model.addAttribute("utilisateur", utilisateur);
		return "CreerUtilisateur";
	}

	/**
	 * sauvegarde d un nouvelle utilisateur et retour sur la page de connexion
	 * 
	 * @param model
	 * @param utilisateur
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/utilisateur/save", method = RequestMethod.POST)
	public String saveUtilisateur(Model model, @Valid Utilisateur utilisateur, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreerUtilisateur";
		}
		utilisateurRepository.save(utilisateur);

		return "redirect:/login";
	}

	/**
	 * affichage des attributs de la classe utilisateur connecte et liste des topos
	 * lier à l'utilisateur
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String profil(Model model) {

		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("utilisateur", utilisateur);
		List<Topo> listTopo = topoRepository.listeDeTopoParUsers(utilisateur.getId());
		model.addAttribute("listTopo", listTopo);

		return "/profil";

	}
}
