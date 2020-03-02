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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LesAmisDeLEscalade.dao.CommentaireSpotRepository;
import com.LesAmisDeLEscalade.dao.LongueurRepository;
import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.UtilisateurRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Commentaire;
import com.LesAmisDeLEscalade.entities.Longueur;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Utilisateur;
import com.LesAmisDeLEscalade.entities.Voie;

@Controller
public class CommentaireSpotController {
	
	@Autowired
	public CommentaireSpotRepository commentairespotRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private LongueurRepository longueurRepository;
	
	@GetMapping(value = "/commentaire/{id}/supprimer")
	public String supprimerCommentaire(Model model, @PathVariable(value = "id") Long id) {
		
		Commentaire commentairespot = commentairespotRepository.findById(id).get();
		Long id_utilisateur = commentairespot.getUtilisateur().getId();
		commentairespotRepository.deleteById(id);
		return "redirect:/site/"+id_utilisateur+"/infoSite";
	}


	@RequestMapping(value = "/site/{id}/commentaire/save", method = RequestMethod.POST)
	public String saveCommentaire(Model model, @Valid @ModelAttribute("commentaire") Commentaire commentaire,
			@PathVariable(value = "id") Long id,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("commentaire",commentaire);
			Site site = siteRepository.findById(id).get();
			model.addAttribute("site",site);
			Utilisateur utilisateur= utilisateurRepository.findById(id).get();
			model.addAttribute("utilisateur",utilisateur);
					
			return "infoSite";
		}
		
		Utilisateur utilisateur= (Utilisateur)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("utilisateur",utilisateur);
		Site site = siteRepository.findById(id).get();
		model.addAttribute("site",site);
		
		commentaire.setDatedeparution(new Date());
		commentaire.setUtilisateur(utilisateur);
		commentaire.setSite(site);
		commentaire.setContenu(commentaire.getContenu());
		commentairespotRepository.save(commentaire);
		
		return "redirect:/site/"+id+"/infoSite";
	}
	
	
	  @RequestMapping(value="/site/{idSite}/commentaire/{idCom}/edit/save",method = RequestMethod.POST)
	  
	  public String saveEditCommentaire(Model model, @Valid Commentaire commentaire, @PathVariable(value = "idCom") Long idCom,@PathVariable(value = "idSite") Long idSite) {
	  
	  
		  Commentaire c = commentairespotRepository.getOne(idCom);
		  Site site = siteRepository.getOne(idSite);
		  
		  c.setDatedeparution(new Date());
		
		  
		  c.setContenu(commentaire.getContenu());
		 
		  
		  c.setSite(site);
		  
		  
		 
		  
		   
		  
		
		  commentairespotRepository.save(c);
		  
		  List<Voie> listVoie = voieRepository.listeDeVoieParSite(idSite);
			model.addAttribute("listVoie", listVoie);

			List<Longueur> listLongueur = longueurRepository.listeDeLongueurParSite(idSite);
			model.addAttribute("listLongueur", listLongueur);

			List<Commentaire> listCommentaire = commentairespotRepository.listeDeCommentaireParSite(idSite);
			model.addAttribute("listCommentaire", listCommentaire);
			
			model.addAttribute("site", site);

			return "infoSite";
	  
	 
	  
	  }
	 
	  @RequestMapping(value="/site/{idSite}/commentaire/{idCom}/edit",method = RequestMethod.GET)
	  public String editCommentaire(Model model, @PathVariable(value = "idCom") Long idCom,@PathVariable(value = "idSite") Long idSite) {
		  
		  
		Site site = siteRepository.getOne(idSite);
		model.addAttribute("site",site);
		  Commentaire commentaire = commentairespotRepository.getOne(idCom);
		  model.addAttribute("commentaire", commentaire);
		
		  			
		  return "modifcommentaire";
	  }
	  
	  }
	 
	 
		
	

	
	


