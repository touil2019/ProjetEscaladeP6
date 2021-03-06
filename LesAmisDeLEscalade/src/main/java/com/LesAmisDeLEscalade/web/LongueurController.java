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

import com.LesAmisDeLEscalade.dao.LongueurRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Longueur;
import com.LesAmisDeLEscalade.entities.Voie;

@Controller
public class LongueurController {

	@Autowired
	public LongueurRepository longueurRepository;
	@Autowired
	private VoieRepository voieRepository;

	/**
	 * supprimer une longueur par le biais de l id de la longueur
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/longueur/{id}/supprimer")
	public String supprimerLongueur(Model model, @PathVariable(value = "id") Long id) {

		longueurRepository.deleteById(id);
		return "redirect:/site";
	}

	/**
	 * formulaire de creation d une longueur lier à une voie et son id
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/voie/{id}/longueur/creer", method = RequestMethod.GET)
	public String creerLongueur(Model model, @PathVariable(value = "id") Long id) {
		Longueur longueur = new Longueur();
		model.addAttribute("longueur", longueur);
		model.addAttribute("idVoie", id);
		return "/CreerLongueur";
	}

	/**
	 * sauvegarder une longueur lier à une voie
	 * 
	 * @param model
	 * @param longueur
	 * @param id
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/voie/{id}/longueur/save", method = RequestMethod.POST)
	public String saveLongueur(Model model, @Valid Longueur longueur, @PathVariable(value = "id") Long id,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreerLongueur";
		}
		Voie voie = voieRepository.findById(id).get();
		longueur.setVoie(voie);
		longueurRepository.save(longueur);

		return "redirect:/site/" + voie.getSite().getId() + "/infoSite";
	}
}
