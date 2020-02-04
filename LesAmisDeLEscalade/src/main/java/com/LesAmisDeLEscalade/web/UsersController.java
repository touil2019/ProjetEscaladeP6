package com.LesAmisDeLEscalade.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LesAmisDeLEscalade.dao.UsersRepository;

import com.LesAmisDeLEscalade.entities.Users;

@Controller
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;
/*
	@RequestMapping(value = "/users/creer", method = RequestMethod.GET)
	public String creerVoie(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		return "CreerUsers";
	}
	*/
/*
	@RequestMapping(value = "/users/save", method = RequestMethod.POST)
	public String saveUsers(Model model, @Valid Users users, BindingResult bindingResult) {
		
		  if (bindingResult.hasErrors()) { return "CreerUsers"; }
		 usersRepository.save(users);
		List<Users> listUsers = usersRepository.findAll();
		model.addAttribute("listUsers", listUsers);

		return "infoUtilisateur";
	}
*/
}
