package com.LesAmisDeLEscalade.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Voie;

@Controller
public class SiteController {
	@Autowired
	private SiteRepository siteRepository;

	@Autowired
	private VoieRepository voieRepository;

	@RequestMapping(value="/site")
	public String site(Model model,@RequestParam(name="page",defaultValue="0")int p,	  
			@RequestParam(name="size",defaultValue="2")int s) {
		
		Page<Site> listSite=siteRepository.findAll(PageRequest.of(p, s));
		model.addAttribute("listSite", listSite);
		List<Voie> listVoie=voieRepository.findAll();
		model.addAttribute("listVoie", listVoie);
		
		int[]pages=new int[listSite.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size",s);
		model.addAttribute("pageCourante",p);
		return "site";		
	}


	@GetMapping(value="/site/{id}/supprimer")
	public String supprimerSite(Model model , @PathVariable(value="id")Long id) {

		siteRepository.deleteById(id);
		return "redirect:/site";
	}

	@RequestMapping(value="/CreerSite",method=RequestMethod.GET)
	public String creer(Model model) {
		Site site=new Site();
		model.addAttribute("site", site);
		return "CreerSite";
	}

	@RequestMapping(value="/Save"
			+ "Site",method=RequestMethod.POST)
	public String save(Model model, @Valid Site site, BindingResult bindingResult) {
		if( bindingResult.hasErrors()) {
			return"CreerSite";
		}
		siteRepository.save(site);
		List<Site> listSite=siteRepository.findAll();
		model.addAttribute("listSite", listSite);
		List<Voie> listVoie=voieRepository.findAll();
		model.addAttribute("listVoie", listVoie);

		return"site";
	}


	@GetMapping(value="/site/trouver") 
	public String trouverSite(Model model,
			
			@RequestParam(name="page",defaultValue="0")int p,	  
			@RequestParam(name="size",defaultValue="2")int s,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		if(!mc.isBlank()) {
			Page<Site> pageSites= siteRepository.chercher("%"+mc+"%",PageRequest.of(p,s));

			model.addAttribute("listSite",pageSites.getContent());
			int[]pages=new int[pageSites.getTotalPages()];
					model.addAttribute("pages",pages);
					model.addAttribute("size",s);
					model.addAttribute("pageCourante",p);
					model.addAttribute("motCle",mc);
					List<Voie> listVoie=voieRepository.findAll();
					model.addAttribute("listVoie", listVoie);
			return"site";
		}
		
		else return"redirect:/site";

				 

	 } 



}


