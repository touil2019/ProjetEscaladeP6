package com.LesAmisDeLEscalade.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.LesAmisDeLEscalade.entities.Utilisateur;
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
	 * affichage de la liste des sites
	 * 
	 * @param model
	 * @param p
	 * @param s
	 * @return
	 */
	@RequestMapping(value = "/site")
	public String site(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {

		Page<Site> listSite = siteRepository.listSite(PageRequest.of(p, s));
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

	/**
	 * suppression d un site par l id
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/site/{id}/supprimer")
	public String supprimerSite(Model model, @PathVariable(value = "id") Long id) {

		siteRepository.deleteById(id);
		return "redirect:/site";
	}

	/**
	 * formulaire de creation d un nouveau site
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/site/creer", method = RequestMethod.GET)
	public String creerSite(Model model) {
		Site site = new Site();
		model.addAttribute("site", site);
		return "CreerSite";
	}

	/**
	 * sauvegarder une nouveau site avec verification de la correspondance des
	 * attributs de la classe site
	 * 
	 * @param model
	 * @param site
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/site/save", method = RequestMethod.POST)
	public String saveSite(Model model, @Valid Site site, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreerSite";
		}
		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("utilisateur", utilisateur);
		site.setUtilisateur(utilisateur);
		siteRepository.save(site);

		return "redirect:/site";
	}

	/**
	 * rechercher un site par mot cle avec pagination
	 * 
	 * @param model
	 * @param p
	 * @param s
	 * @param mc
	 * @return
	 */
	@GetMapping(value = "/site/trouver")
	public String trouverSite(Model model,

			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "4") int s,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		if (!mc.isBlank()) {
			Page<Site> pageSites = siteRepository.chercher("%" + mc + "%", PageRequest.of(p, s));
			model.addAttribute("listSite", pageSites.getContent());
			int[] pages = new int[pageSites.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("size", s);
			model.addAttribute("pageCourante", p);
			model.addAttribute("motCle", mc);
			return "site";
		}

		else
			return "redirect:/site";

	}

	/**
	 * affichage d'un site par le biais de son id. affichage des voies longueurs et
	 * commentaires lier à l id du site avec pagination
	 * 
	 * @param model
	 * @param id
	 * @param p
	 * @param s
	 * @return
	 */
	@RequestMapping(value = "/site/{id}/infoSite")
	public String infoSite(Model model, @PathVariable(value = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {

		Site site = siteRepository.findById(id).get();
		model.addAttribute("site", site);

		List<Voie> listVoie = voieRepository.listeDeVoieParSite(id);
		model.addAttribute("listVoie", listVoie);

		List<Longueur> listLongueur = longueurRepository.listeDeLongueurParSite(id);
		model.addAttribute("listLongueur", listLongueur);

		List<Commentaire> listCommentaire = commentaireSpotRepository.listeDeCommentaireParSite(id);
		model.addAttribute("listCommentaire", listCommentaire);

		return "infoSite";
	}

	/**
	 * declarer un site officiel
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/site/{id}/officiel")
	public String siteOfficiel(Model model, @PathVariable(value = "id") Long id) {

		Site site = siteRepository.findById(id).get();
		site.setOfficiel(!site.isOfficiel());
		siteRepository.save(site);

		return "redirect:/site/" + id + "/infoSite";
	}

}
