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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	
	  private static final Logger logger =
	  LogManager.getLogger(LoginController.class);
	  
	  @RequestMapping(value = "/login", method = RequestMethod.GET) public
	  ModelAndView loginGet() { Authentication auth =
	  SecurityContextHolder.getContext().getAuthentication();
	  
	  if (!(auth instanceof AnonymousAuthenticationToken)) { return new
	  ModelAndView("redirect:/login"); } return new ModelAndView("login"); }
	  
	  @RequestMapping(value="/logout", method = RequestMethod.GET) public String
	  logoutPage (HttpServletRequest request, HttpServletResponse response) {
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (auth != null){
	  logger.info("L'utilisateur "+SecurityContextHolder.getContext().
	  getAuthentication().getName()+" s'est déconnecté"); new
	  SecurityContextLogoutHandler().logout(request, response, auth); } return
	  "redirect:/site"; }
	 
	
	/*
	 * @GetMapping(value= "/login") public String login(){
	 * 
	 * return "/login"; }
	 */
	
}