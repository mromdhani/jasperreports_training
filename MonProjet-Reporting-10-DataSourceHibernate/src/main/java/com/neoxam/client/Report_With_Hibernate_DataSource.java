package com.neoxam.client;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuter;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;

public class Report_With_Hibernate_DataSource {
	
	public static void main(String[] args) {
		
		// Démarrer la session factory hibernate
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		
		// Obtenir une session de la factory
		Session session = factory.openSession();	
   
		
		Map parameterMap = new HashedMap();
		parameterMap.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, session);

		
		try {
			// Compilation du JRXML et Production du template
//			JasperCompileManager.compileReportToFile("reports/report-0-hello.jrxml", "reports/report-0-hello.jasper");

			// Remplissage du template et production du jrprint
			JasperFillManager.fillReportToFile ("reports/report-banque-hibernate.jasper", "reports/report-banque-hibernate.jrprint", 
					parameterMap);
				//	new JREmptyDataSource());

			// Export du PDF
			JasperExportManager.exportReportToPdfFile("reports/report-banque-hibernate.jrprint", 
					 "reports/report-banque-hibernate.pdf");

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la génération");
	}
}
