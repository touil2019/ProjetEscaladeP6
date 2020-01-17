package com.LesAmisDeLEscalade.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.LesAmisDeLEscalade.dao.CommentaireSpotRepository;

@Controller
public class CommentaireSpot {
	
	@Autowired
	public CommentaireSpotRepository commentairespotRepository;

}
