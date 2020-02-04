package com.LesAmisDeLEscalade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LesAmisDeLEscalade.dao.LongueurRepository;
import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.TopoRepository;
import com.LesAmisDeLEscalade.dao.UsersRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Longueur;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Topo;
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
	@Autowired
	private TopoRepository topoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LesAmisDeLEscaladeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Site site1 = new Site("le pic de dante", "Guyane", "Maripasoula");
		siteRepository.save(site1);
		
		Site site2 = new Site("le pic vert", "Réunion", "Bois de Nèfles");
		siteRepository.save(site2);
		
		
		Site site3 = new Site("le pic rouge","Mayotte","Mamoudzou");
		siteRepository.save(site3);
		
		Voie voie1 = new Voie("secteur1", "4C", 10, "Chemin Maripasoula");
		voie1.setSite(site1);
		voieRepository.save(voie1);

		Voie voie2 = new Voie("secteur2", "6C", 10, "Pic du col vert");
		voie2.setSite(site1);
		voieRepository.save(voie2);
		
		Voie voie3 = new Voie("secteur3", "8C", 10, "Passage du colibri");
		voie3.setSite(site2);
		voieRepository.save(voie3);
		
		Voie voie4 = new Voie("secteur1", "9C", 10, "Route des fleurs");
		voie4.setSite(site2);
		voieRepository.save(voie4);

		Voie voie5 = new Voie("secteur2", "7C", 9, "Chemin des Amaryllis");
		voie5.setSite(site3);
		voieRepository.save(voie5);
		
		Voie voie6 = new Voie("secteur3", "5B", 8, "Col de la Croix-haute");
		voie6.setSite(site3);
		voieRepository.save(voie6);
		
		longueurRepository.save(new Longueur("Passage Maripasoula", 800, "4C"));
		longueurRepository.save(new Longueur("Boucle sable blanc", 200, "4B"));
		longueurRepository.save(new Longueur("Boucle de la clairiere", 400, "4C"));
		longueurRepository.save(new Longueur("Allée aux chasseurs", 700, "10B"));
		longueurRepository.save(new Longueur("Route du postier", 300, "5C"));
		longueurRepository.save(new Longueur("Grand Fromagier", 500, "7B"));
		longueurRepository.save(new Longueur("Chemin du col vert", 400, "1B"));
		longueurRepository.save(new Longueur("Col du boi vaillant", 800, "2B"));
		longueurRepository.save(new Longueur("Bois de Nèfles", 400, "6C"));
		longueurRepository.save(new Longueur("Plage de l'éméraude", 900, "5C"));
		longueurRepository.save(new Longueur("Falaise du diamant", 1200, "7B"));
		longueurRepository.save(new Longueur("Route du vieux phare", 1400, "2B"));

		usersRepository.save(new Users());
		usersRepository.save(new Users());
		usersRepository.save(new Users());
		usersRepository.save(new Users());

		topoRepository.save(new Topo());
		topoRepository.save(new Topo());
		topoRepository.save(new Topo());
		topoRepository.save(new Topo());
	}

}
