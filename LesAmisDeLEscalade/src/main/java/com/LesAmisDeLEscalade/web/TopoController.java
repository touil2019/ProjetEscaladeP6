package com.LesAmisDeLEscalade.web;

import java.util.Date;

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

import com.LesAmisDeLEscalade.dao.TopoRepository;
import com.LesAmisDeLEscalade.entities.Topo;

@Controller
public class TopoController {

	@Autowired
	private TopoRepository topoRepository;

	@RequestMapping(value = "/topo/creer", method = RequestMethod.GET)
	public String creerTopo(Model model) {
		Topo topo = new Topo();
		model.addAttribute("topo", topo);
		return "/CreerTopo";
	}

	@RequestMapping(value = "/topo/save", method = RequestMethod.POST)
	public String saveTopo(Model model, @Valid Topo topo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreerTopo";
		}
		topo.setDisponible(true);
		topo.setDate(new Date());
		model.addAttribute("topo", topo);
		topoRepository.save(topo);
		return "redirect:/topo";
	}

	@GetMapping(value = "/topo")
	public String allTopo(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "9999") int s) {

		Page<Topo> listTopo = topoRepository.findAll(PageRequest.of(p, s));

		model.addAttribute("listTopo", listTopo);

		return "/topo";
	}

	@GetMapping(value = "/topo/{id}/supprimer")
	public String supprimerTopo(Model model, @PathVariable(value = "id") Long id) {

		topoRepository.deleteById(id);
		return "redirect:/topo";
	}
	

	@RequestMapping(value = "/topo/{id}/infoTopo")
	public String infoTopo(Model model, @PathVariable(value = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {

	Topo topo = topoRepository.findById(id).get();
	model.addAttribute("topo",topo);
	
					
		return  "infotopo";
	}
}
