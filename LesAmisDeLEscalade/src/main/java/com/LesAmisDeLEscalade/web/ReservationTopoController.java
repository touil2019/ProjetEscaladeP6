/*
 * package com.LesAmisDeLEscalade.web;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import com.LesAmisDeLEscalade.dao.ReservationTopoRepository; import
 * com.LesAmisDeLEscalade.dao.TopoRepository; import
 * com.LesAmisDeLEscalade.dao.UtilisateurRepository; import
 * com.LesAmisDeLEscalade.entities.Utilisateur;
 * 
 * import groovyjarjarpicocli.CommandLine.Model;
 * 
 * @Controller public class ReservationTopoController {
 * 
 * @Autowired public ReservationTopoRepository reservationtopoRepository;
 * 
 * @Autowired private TopoRepository topoRepository;
 * 
 * @Autowired private UtilisateurRepository utilisateurRepository;
 * 
 * 
 * @RequestMapping(value = "/topo/{id}/mesReservations",
 * method=RequestMethod.GET)
 * 
 * public String Reservationemise(Model model, @PathVariable(value = "id") Long
 * id);
 * 
 * {
 * 
 * Utilisateur utilisateur=
 * (Utilisateur)SecurityContextHolder.getContext().getAuthentication().
 * getPrincipal(); model.addAttribute("utilisateur",utilisateur); Topo topo
 * =topoRepository.findById(id).get(); model.addAttribute("topo",topo);
 * List<ReservationTopo>= reservationtopoRepository.findById(id).get();
 * model.addAttribute("reservationtopo",reservationtopo);
 * 
 * return "mesReservations";
 * 
 * }
 * 
 * }
 */