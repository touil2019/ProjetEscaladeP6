package com.LesAmisDeLEscalade.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LesAmisDeLEscalade.dao.LongueurRepository;
import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Longueur;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Voie;

@Controller
public class VoieController {

	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private LongueurRepository longueurRepository;
	@Autowired
	private SiteRepository siteRepository;

	@GetMapping(value = "/voie/{id}/supprimer")
	public String supprimerVoie(Model model, @PathVariable(value = "id") Long id) {

		voieRepository.deleteById(id);
		return "redirect:/site";
	}

	@RequestMapping(value = "/site/{id}/voie/creer", method = RequestMethod.GET)
	public String creerVoie(Model model, @PathVariable(value = "id") Long id) {
		Voie voie = new Voie();
		model.addAttribute("voie", voie);
		model.addAttribute("idSite", id);
		return "CreerVoie";

	}

	@RequestMapping(value = "/site/{idURL}/voie/save", method = RequestMethod.POST)
	public String saveVoie(Model model, @Valid Voie voie,
			@PathVariable(value = "idURL") Long id,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "CreerVoie";
		}
		Site site= siteRepository.findById(id).get();
		voie.setSite(site);
		voieRepository.save(voie);
		
		return "redirect:/site/"+id+"/infoSite";
	}
}