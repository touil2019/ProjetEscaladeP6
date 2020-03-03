
package com.LesAmisDeLEscalade.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.LesAmisDeLEscalade.dao.ReservationTopoRepository;
import com.LesAmisDeLEscalade.entities.ReservationTopo;

@Controller
public class ReservationTopoController {

	@Autowired
	public ReservationTopoRepository reservationtopoRepository;

	@GetMapping(value = "/reservation")
	public String listeDeRes(Model model) {

		
		List<ReservationTopo> listeDeRes = reservationtopoRepository.findAll();
		model.addAttribute("listeDeRes", listeDeRes);

		return "reservation";
  
  }
	
}	
