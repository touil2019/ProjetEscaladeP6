package com.LesAmisDeLEscalade.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LesAmisDeLEscalade.dao.CommentaireSpotRepository;
import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.UtilisateurRepository;
import com.LesAmisDeLEscalade.entities.Commentaire;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Utilisateur;

@Controller
public class CommentaireSpotController {
	
	@Autowired
	public CommentaireSpotRepository commentairespotRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private SiteRepository siteRepository;
	
	@GetMapping(value = "/commentaire/{id}/supprimer")
	public String supprimerCommentaire(Model model, @PathVariable(value = "id") Long id) {
		
		Commentaire commentairespot = commentairespotRepository.findById(id).get();
		Long id_utilisateur = commentairespot.getUtilisateur().getId();
		commentairespotRepository.deleteById(id);
		return "redirect:/site/"+id_utilisateur+"/infoSite";
	}

	@RequestMapping(value = "/site/{id}/commentaire/creer", method = RequestMethod.GET)
	public String creerCommentaire(Model model, @PathVariable(value = "id") Long id) {
		Commentaire commentaire = new Commentaire();
		model.addAttribute("commentaire", commentaire);
		model.addAttribute("id_utilisateur", id);
		return "InfoSite";

	}

	@RequestMapping(value = "/site/{idURL}/commentaire/save", method = RequestMethod.POST)
	public String saveCommentaire(Model model, @Valid Commentaire commentaire,
			@PathVariable(value = "idURL") Long id,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "infoSite";
		}
		Utilisateur utilisateur= utilisateurRepository.findById(id).get();
		Site site = siteRepository.findById(id).get();
		commentaire.setUtilisateur(utilisateur);
		commentaire.setSite(site);
		commentairespotRepository.save(commentaire);
		
		return "redirect:/site/"+id+"/infoSite";
	}

	@RequestMapping(value = "/commentaire/{id}/infoSite")
	public String infoCommentaire(Model model, @PathVariable(value = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {

	Commentaire commentaire = commentairespotRepository.findById(id).get();
	model.addAttribute("commentaire",commentaire);
	

		
		return "infoSite";
	}
}

