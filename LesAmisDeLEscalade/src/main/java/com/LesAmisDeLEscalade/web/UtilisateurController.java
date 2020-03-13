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
	@RequestMapping(value = "/profil",method = RequestMethod.GET)
	public String profil(Model model) {

		Utilisateur utilisateur= (Utilisateur)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("utilisateur",utilisateur);
		List<Topo> listTopo = topoRepository.listeDeTopoParUsers(utilisateur.getId());
		model.addAttribute("listTopo", listTopo);
	
					
		return  "/profil";
	
	}
}
