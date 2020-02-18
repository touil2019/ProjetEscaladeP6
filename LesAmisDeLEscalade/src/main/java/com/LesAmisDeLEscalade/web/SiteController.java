package com.LesAmisDeLEscalade.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LesAmisDeLEscalade.dao.CommentaireSpotRepository;
import com.LesAmisDeLEscalade.dao.LongueurRepository;
import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Commentaire;
import com.LesAmisDeLEscalade.entities.Longueur;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Voie;

@Controller
public class SiteController {
	@Autowired
	private SiteRepository siteRepository;

	@Autowired
	private VoieRepository voieRepository;

	@Autowired
	private LongueurRepository longueurRepository;
	
	@Autowired
	private CommentaireSpotRepository commentaireSpotRepository;
/**
 * 
 * @param model
 * @param p
 * @param s
 * @return
 */
	@RequestMapping(value = "/site")
	public String site(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {

		Page<Site> listSite = siteRepository.findAll(PageRequest.of(p, s));
		model.addAttribute("listSite", listSite);
		List<Voie> listVoie = voieRepository.findAll();
		model.addAttribute("listVoie", listVoie);
		List<Longueur> listLongueur = longueurRepository.findAll();
		model.addAttribute("listLongueur", listLongueur);

		int[] pages = new int[listSite.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		return "site";
	}

	@GetMapping(value = "/site/{id}/supprimer")
	public String supprimerSite(Model model, @PathVariable(value = "id") Long id) {

		siteRepository.deleteById(id);
		return "redirect:/site";
	}

	@RequestMapping(value = "/site/creer", method = RequestMethod.GET)
	public String creerSite(Model model) {
		Site site = new Site();
		model.addAttribute("site", site);
		return "CreerSite";
	}

	@RequestMapping(value = "/site/save", method = RequestMethod.POST)
	public String saveSite(Model model, @Valid Site site, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreerSite";
		}
		siteRepository.save(site);
		List<Site> listSite = siteRepository.findAll();
		model.addAttribute("listSite", listSite);
		List<Voie> listVoie = voieRepository.findAll();
		model.addAttribute("listVoie", listVoie);
		List<Longueur> listLongueur = longueurRepository.findAll();
		model.addAttribute("listLongueur", listLongueur);

		return "site";
	}

	@GetMapping(value = "/site/trouver")
	public String trouverSite(Model model,

			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		if (!mc.isBlank()) {
			Page<Site> pageSites = siteRepository.chercher("%" + mc + "%", PageRequest.of(p, s));

			model.addAttribute("listSite", pageSites.getContent());
			int[] pages = new int[pageSites.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("size", s);
			model.addAttribute("pageCourante", p);
			model.addAttribute("motCle", mc);
			List<Voie> listVoie = voieRepository.findAll();
			model.addAttribute("listVoie", listVoie);
			return "site";
		}

		else
			return "redirect:/site";

	}

	@RequestMapping(value = "/site/{id}/infoSite")
	public String infoSite(Model model, @PathVariable(value = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {

	Site site= siteRepository.findById(id).get();
	model.addAttribute("site",site);
	
		List<Voie> listVoie = voieRepository.listeDeVoieParSite(id);
		model.addAttribute("listVoie", listVoie);
		
		List<Longueur> listLongueur = longueurRepository.listeDeLongueurParSite(id);
		model.addAttribute("listLongueur", listLongueur);
		
		List<Commentaire> listCommentaire= commentaireSpotRepository.listeDeCommentaireParSite(id);
		model.addAttribute("listCommentaire", listCommentaire);
		
		return "infoSite";
	}
	



}


