package com.LesAmisDeLEscalade.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.LesAmisDeLEscalade.dao.ReservationTopoRepository;
import com.LesAmisDeLEscalade.dao.TopoRepository;
import com.LesAmisDeLEscalade.dao.UtilisateurRepository;
import com.LesAmisDeLEscalade.entities.ReservationTopo;
import com.LesAmisDeLEscalade.entities.Topo;
import com.LesAmisDeLEscalade.entities.Utilisateur;

@Controller
public class ReservationTopoController {

	@Autowired
	public ReservationTopoRepository reservationtopoRepository;
	@Autowired
	public TopoRepository topoRepository;
	@Autowired
	public UtilisateurRepository utilisateurRepository;

	/**
	 * affichage des demandes de reservations emises et recues pour un utilisateur
	 * connecte
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/reservation")
	public String listeDeResa(Model model) {

		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ReservationTopo> listeDeResaEmises = reservationtopoRepository.listeDeResaEmises(utilisateur.getId());

		model.addAttribute("utilisateur", utilisateur);
		model.addAttribute("listeDeResaEmises", listeDeResaEmises);

		List<ReservationTopo> listeDeResaRecues = reservationtopoRepository.listeDeResaReçues(utilisateur.getId());
		model.addAttribute("listeDeResaRecues", listeDeResaRecues);

		return "reservation";

	}

	/**
	 * demande de reservation d un topo par le biais de l id du topo
	 * 
	 * @param model
	 * @param idtopo
	 * @return
	 */
	@GetMapping(value = "/topo/{idTopo}/reserver")
	public String Reserver(Model model, @PathVariable(value = "idTopo") Long idtopo) {

		ReservationTopo reservationTopo = new ReservationTopo();
		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Topo topo = topoRepository.getOne(idtopo);

		reservationTopo.setDateemprunt(new Date());
		reservationTopo.setAcceptations(false);
		reservationTopo.setUtilisateur(utilisateur);
		reservationTopo.setTopo(topo);
		reservationtopoRepository.save(reservationTopo);

		return "redirect:/topo/" + idtopo + "/infoTopo";
	}

	/**
	 * accepter une demande de reservation
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/reservation/{id}/accepter")
	public String accepterReservation(Model model, @PathVariable(value = "id") Long id) {

		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ReservationTopo reservationTopo = reservationtopoRepository.findById(id).get();
		reservationTopo.setAcceptations(true);
		reservationtopoRepository.save(reservationTopo);

		Topo topo = topoRepository.findById(reservationTopo.getTopo().getId()).get();
		topo.setDisponible(false);
		topoRepository.save(topo);

		return "redirect:/reservation";

	}

	/**
	 * refuser une demande de reservation
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/reservation/{id}/refuser")
	public String refuserrReservation(Model model, @PathVariable(value = "id") Long id) {

		Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ReservationTopo reservationTopo = reservationtopoRepository.findById(id).get();
		reservationTopo.setAcceptations(false);
		reservationtopoRepository.save(reservationTopo);

		Topo topo = topoRepository.findById(reservationTopo.getTopo().getId()).get();
		topo.setDisponible(true);
		topoRepository.save(topo);

		return "redirect:/reservation";

	}

}
