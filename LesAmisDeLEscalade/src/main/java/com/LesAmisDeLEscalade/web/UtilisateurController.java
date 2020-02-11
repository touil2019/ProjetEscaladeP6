package com.LesAmisDeLEscalade.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.LesAmisDeLEscalade.dao.UtilisateurRepository;


@Controller
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

}
