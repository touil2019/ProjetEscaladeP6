package com.LesAmisDeLEscalade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Voie;

@SpringBootApplication
public class LesAmisDeLEscaladeApplication implements CommandLineRunner {
@Autowired
	private SiteRepository siteRepository;
@Autowired
	private VoieRepository voieRepository;

	public static void main(String[] args) {
	SpringApplication.run(LesAmisDeLEscaladeApplication.class, args);
	}
@Override
	public void run(String... args) throws Exception {
	siteRepository.save(new Site("le pic de dante","Guyane","Maripasoula"));
	siteRepository.save(new Site("le pic vert", "Réunion", "Bois de Nèfles"));
	siteRepository.save(new Site("le pic rouge", "Mayotte", "Mamoudzou"));

	voieRepository.save(new Voie("4C",10,"chemin Maripasoula"));
	voieRepository.save(new Voie("6C",10,"pic du col vert"));
	voieRepository.save(new Voie("8C",10,"passage du colibri"));
	voieRepository.save(new Voie("9C",10,"route des fleurs"));
	}

}
