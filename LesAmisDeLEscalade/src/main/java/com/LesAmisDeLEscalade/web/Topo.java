package com.LesAmisDeLEscalade.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.LesAmisDeLEscalade.dao.TopoRepository;

@Controller
public class Topo {

	@Autowired
	private TopoRepository topoRepository;
}
