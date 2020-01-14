package com.LesAmisDeLEscalade.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.LesAmisDeLEscalade.dao.VoieRepository;

@Controller
public class VoieController {
	
@Autowired
private VoieRepository voieRepository;

	@GetMapping(value="/voie/{id}/supprimer")
	public String supprimerVoie(Model model , @PathVariable(value="id")Long id) {
		
		voieRepository.deleteById(id);
		return "redirect:/site";
	}
}
