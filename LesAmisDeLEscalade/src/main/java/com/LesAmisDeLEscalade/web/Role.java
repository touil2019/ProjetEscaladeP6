package com.LesAmisDeLEscalade.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.LesAmisDeLEscalade.dao.RoleRepository;

@Controller
public class Role {
	
	@Autowired
	public RoleRepository roleRepository;

}
