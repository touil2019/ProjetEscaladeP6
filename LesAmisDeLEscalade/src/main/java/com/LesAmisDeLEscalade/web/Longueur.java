package com.LesAmisDeLEscalade.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.LesAmisDeLEscalade.dao.LongueurRepository;

@Controller
public class Longueur {
	
	@Autowired
	public LongueurRepository longueurRepository;

}
