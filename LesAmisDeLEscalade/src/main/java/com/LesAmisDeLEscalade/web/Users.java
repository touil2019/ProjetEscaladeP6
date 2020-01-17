package com.LesAmisDeLEscalade.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.LesAmisDeLEscalade.dao.UsersRepository;

@Controller
public class Users {
	
	@Autowired
	private UsersRepository usersRepository;

}
