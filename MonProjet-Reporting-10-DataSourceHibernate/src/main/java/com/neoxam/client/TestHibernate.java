package com.neoxam.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neoxam.entities.Compte;

public class TestHibernate {

	public static void main(String[] args) {
		
		// Démarrer la session factory hibernate
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		
		// Obtenir une session de la factory
		Session session = factory.openSession();
		
		// Travailler sur les objets perisistants via la session
		Query query = session.createQuery("From Compte");  // Requete HQL
		
		List<Compte> tous = query.list();
		for (Compte compte : tous) {
			System.out.println(compte);
		}	
		
		// Libérer la session
		session.close();		
		// Libérer ka factory
		factory.close();

	}

}
