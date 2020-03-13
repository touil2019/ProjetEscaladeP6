package com.LesAmisDeLEscalade.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LesAmisDeLEscalade.dao.TopoRepository;
import com.LesAmisDeLEscalade.dao.UtilisateurRepository;
import com.LesAmisDeLEscalade.entities.Topo;
import com.LesAmisDeLEscalade.entities.Utilisateur;

@Controller
public class TopoController {

	@Autowired
	private TopoRepository topoRepository;

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	/**
	 * envoi vers le formulaire de creation de nouveau topo
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/topo/creer", method = RequestMethod.GET)
	public String creerTopo(Model model) {
		Topo topo = new Topo();
		model.addAttribute("topo", topo);
		return "CreerTopo";
	}

	/**
	 * sauvegarde du formulaire de création de nouveau topo et retourne la vue topo
	 * 
	 * @param model
	 * @param topo
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/topo/save", method = RequestMethod.POST)
	public String saveTopo(Model model, @Valid Topo topo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreerTopo";
		}
		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		topo.setUtilisateur(utilisateur);
		topo.setDisponible(true);
		topo.setDate(new Date());
		topoRepository.save(topo);

		return "redirect:/topo";
	}

	/**
	 * affiche tout les topos disponibles
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping(value = "/topo")
	public String allTopo(Model model) {

		List<Topo> listTopo = topoRepository.listeDeTopoDispo();
		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("utilisateur", utilisateur);
		model.addAttribute("listTopo", listTopo);

		return "topo";
	}

	/**
	 * suppression du topo par l'id de celui ci
	 * 
	 * @param model
	 * @param id
	 * @return
	 */

	@GetMapping(value = "/topo/{id}/supprimer")
	public String supprimerTopo(Model model, @PathVariable(value = "id") Long id) {

		topoRepository.deleteById(id);
		return "redirect:/topo";
	}

	/**
	 * affichage des informations d'un topo lors de la session utilisateur par l'id
	 * du topo, avec pagination et affichage de deux topos par pages.
	 * 
	 * @param model
	 * @param id
	 * @param p
	 * @param s
	 * @return
	 */

	@RequestMapping(value = "/topo/{id}/infoTopo")
	public String infoTopo(Model model, @PathVariable(value = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {

		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("utilisateur", utilisateur);
		Topo topo = topoRepository.findById(id).get();
		model.addAttribute("topo", topo);

		return "infotopo";
	}

	/**
	 * modification de la disponibilite du topo
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/infotopo/{id}/disponible")
	public String topoDisponible(Model model, @PathVariable(value = "id") Long id) {

		Topo topo = topoRepository.findById(id).get();
		topo.setDisponible(!topo.isDisponible());
		topoRepository.save(topo);

		return "redirect:/topo/" + id + "/infoTopo";
	}

}
