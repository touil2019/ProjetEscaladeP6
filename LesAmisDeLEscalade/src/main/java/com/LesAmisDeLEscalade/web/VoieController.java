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

import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Voie;

@Controller
public class VoieController {

	@Autowired
	private VoieRepository voieRepository;

	@Autowired
	private SiteRepository siteRepository;

	/**
	 * suppression de la voie par l'id avec une correspondance avec l'id du site
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/voie/{id}/supprimer")
	public String supprimerVoie(Model model, @PathVariable(value = "id") Long id) {

		Voie voie = voieRepository.findById(id).get();
		Long idSite = voie.getSite().getId();
		voieRepository.deleteById(id);
		return "redirect:/site/" + idSite + "/infoSite";
	}

	/**
	 * creation d'une nouvelle voie avec affichage du formulaire
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/site/{id}/voie/creer", method = RequestMethod.GET)
	public String creerVoie(Model model, @PathVariable(value = "id") Long id) {
		Voie voie = new Voie();
		model.addAttribute("voie", voie);
		model.addAttribute("idSite", id);
		return "CreerVoie";

	}

	/**
	 * sauvegarde du formulaire de creation de nouvelle voie avec une verification
	 * de la correspondance des attributs avec la classe voie
	 * 
	 * @param model
	 * @param voie
	 * @param id
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/site/{idURL}/voie/save", method = RequestMethod.POST)
	public String saveVoie(Model model, @Valid Voie voie, @PathVariable(value = "idURL") Long id,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "CreerVoie";
		}
		Site site = siteRepository.findById(id).get();
		voie.setSite(site);
		voieRepository.save(voie);

		return "redirect:/site/" + id + "/infoSite";
	}
}