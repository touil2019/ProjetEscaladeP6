package com.LesAmisDeLEscalade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LesAmisDeLEscalade.dao.LongueurRepository;
import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.UsersRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Longueur;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Users;
import com.LesAmisDeLEscalade.entities.Voie;

@SpringBootApplication
public class LesAmisDeLEscaladeApplication implements CommandLineRunner {
	
@Autowired
	private SiteRepository siteRepository;
@Autowired
	private VoieRepository voieRepository;
@Autowired
	private LongueurRepository longueurRepository;
@Autowired
	private UsersRepository usersRepository;


	public static void main(String[] args) {
	SpringApplication.run(LesAmisDeLEscaladeApplication.class, args);
	}
@Override
	public void run(String... args) throws Exception {
		
	siteRepository.save(new Site(null, "le pic de dante","Guyane","Maripasoula", null));
	siteRepository.save(new Site(null, "le pic vert", "Réunion", "Bois de Nèfles", null));
	siteRepository.save(new Site(null, "le pic rouge", "Mayotte", "Mamoudzou", null));
		 

	voieRepository.save(new Voie("secteur1","4C",10,"Chemin Maripasoula"));
	voieRepository.save(new Voie("secteur2","6C",10,"Pic du col vert"));
	voieRepository.save(new Voie("secteur3","8C",10,"Passage du colibri"));
	voieRepository.save(new Voie("secteur1","9C",10,"Route des fleurs"));
	voieRepository.save(new Voie("secteur2","7C",9,"Chemin des Amaryllis"));
	voieRepository.save(new Voie("secteur3","5B",8,"Col de la Croix-haute"));
	
	longueurRepository.save(new Longueur("Passage Maripasoula",800,"4C"));
	longueurRepository.save(new Longueur("Boucle sable blanc",200,"4B"));
	longueurRepository.save(new Longueur("Boucle de la clairiere",400,"4C"));
	longueurRepository.save(new Longueur("Allée aux chasseurs",700,"10B"));
	longueurRepository.save(new Longueur("Route du postier",300,"5C"));
	longueurRepository.save(new Longueur("Grand Fromagier",500,"7B"));
	longueurRepository.save(new Longueur("Chemin du col vert",400,"1B"));
	longueurRepository.save(new Longueur("Col du bois vaillant",800,"2B"));
	longueurRepository.save(new Longueur("Bois de Nèfles",400,"6C"));
	longueurRepository.save(new Longueur("Plage de l'éméraude",900,"5C"));
	longueurRepository.save(new Longueur("Falaise du diamant",1200,"7B"));
	longueurRepository.save(new Longueur("Route du vieux phare",1400,"2B"));
	
		
	usersRepository.save(new Users()); 
	usersRepository.save(new Users());
	usersRepository.save(new Users());
	usersRepository.save(new Users());
		 
	
	}

}
