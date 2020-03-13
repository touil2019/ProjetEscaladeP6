package com.LesAmisDeLEscalade.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final Logger logger = LogManager.getLogger(LoginController.class);

	/**
	 * connexion au site avec ModelAndView pour renvoyer un modèle et une vue en une
	 * seule étape et si erreur retour sur la liste des sites
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {

			return new ModelAndView("redirect:/site");
		}

		return new ModelAndView("login");
	}

	/**
	 * déconnexion de l'utilisateur connecte
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)

	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			logger.info("L'utilisateur " + SecurityContextHolder.getContext().getAuthentication().getName()
					+ " s'est déconnecté");

			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/site";
	}

}