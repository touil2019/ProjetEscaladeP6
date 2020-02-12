package com.LesAmisDeLEscalade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LesAmisDeLEscalade.dao.LongueurRepository;
import com.LesAmisDeLEscalade.dao.SiteRepository;
import com.LesAmisDeLEscalade.dao.TopoRepository;
import com.LesAmisDeLEscalade.dao.UtilisateurRepository;
import com.LesAmisDeLEscalade.dao.VoieRepository;
import com.LesAmisDeLEscalade.entities.Longueur;
import com.LesAmisDeLEscalade.entities.Site;
import com.LesAmisDeLEscalade.entities.Topo;
import com.LesAmisDeLEscalade.entities.Utilisateur;
import com.LesAmisDeLEscalade.entities.Voie;
import com.LesAmisDeLEscalade.security.RoleEnum;

@SpringBootApplication
public class LesAmisDeLEscaladeApplication implements CommandLineRunner {

	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private LongueurRepository longueurRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private TopoRepository topoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LesAmisDeLEscaladeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Utilisateur user = new Utilisateur("user","user","user","user","user1@gmail.com");
		Set<RoleEnum> userRole =new HashSet<>();
		userRole.add(RoleEnum.ROLE_USER);
        user.setRoles(userRole);
		utilisateurRepository.save(user);
		
		Utilisateur admin = new Utilisateur("admin","admin","admin","admin","admin1@gmail.com");
		Set<RoleEnum> adminRole =new HashSet<>();
		adminRole.add(RoleEnum.ROLE_USER);
        adminRole.add(RoleEnum.ROLE_ADMIN);
        admin.setRoles(adminRole);
		utilisateurRepository.save(admin);
		
		Site site1 = new Site("le pic de dante", "Guyane", "Maripasoula");
		site1.setUtilisateur(user);
		siteRepository.save(site1);

		Site site2 = new Site("le pic vert", "Réunion", "Bois de Nèfles");
		site2.setUtilisateur(user);
		siteRepository.save(site2);

		Site site3 = new Site("le pic rouge", "Mayotte", "Mamoudzou");
		site3.setUtilisateur(admin);
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

		Longueur longueur1 = new Longueur("Passage Maripasoula", 800, "4C");
		longueur1.setVoie(voie1);
		longueurRepository.save(longueur1);

		Longueur longueur2 = new Longueur("Boucle sable blanc", 200, "4B");
		longueur2.setVoie(voie1);
		longueurRepository.save(longueur2);
		
		Longueur longueur3 = new Longueur("Boucle de la clairiere", 400, "4C");
		longueur3.setVoie(voie2);
		longueurRepository.save(longueur3);

		Longueur longueur4 = new Longueur("Allée aux chasseurs", 700, "10B");
		longueur4.setVoie(voie2);
		longueurRepository.save(longueur4);

		Longueur longueur5 = new Longueur("Route du postier", 300, "5C");
		longueur5.setVoie(voie3);
		longueurRepository.save(longueur5);

		Longueur longueur6 = new Longueur("Grand Fromagier", 500, "7B");
		longueur6.setVoie(voie3);
		longueurRepository.save(longueur6);
		

		Longueur longueur7 = new Longueur("Chemin du col vert", 400, "1B");
		longueur7.setVoie(voie4);
		longueurRepository.save(longueur7);

		Longueur longueur8 = new Longueur("Col du bois vaillant", 800, "2B");
		longueur8.setVoie(voie4);
		longueurRepository.save(longueur8);

		Longueur longueur9 = new Longueur("Bois de Nèfles", 400, "6C");
		longueur9.setVoie(voie5);
		longueurRepository.save(longueur9);

		Longueur longueur10 = new Longueur("Plage de l'éméraude", 900, "5C");
		longueur10.setVoie(voie5);
		longueurRepository.save(longueur10);

		Longueur longueur11 = new Longueur("Falaise du diamant", 1200, "7B");
		longueur11.setVoie(voie6);
		longueurRepository.save(longueur11);

		Longueur longueur12 = new Longueur("Route du vieux phare", 1400, "2B");
		longueur12.setVoie(voie6);
		longueurRepository.save(longueur12);
	

		Topo topo1= new Topo("Saint-Pierre","cadre accueillant",true,new Date());
		topo1.setUtilisateur(admin);
		topoRepository.save(topo1);
		
		Topo topo2= new Topo("Croix Verte","lieu ensoleillé",true,new Date());
		topo2.setUtilisateur(admin);
		topoRepository.save(topo2);
		
		Topo topo3= new Topo("Maripasoula","plage vierge",true,new Date());
		topo3.setUtilisateur(user);
		topoRepository.save(topo3);
		
		Topo topo4= new Topo("Bois de Nèfles","ballade buccolique",true,new Date());
		topo4.setUtilisateur(user);
		topoRepository.save(topo4);		
		
		
	}

}
