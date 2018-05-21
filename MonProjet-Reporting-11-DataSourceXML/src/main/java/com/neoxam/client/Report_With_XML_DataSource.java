package com.neoxam.client;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

public class Report_With_XML_DataSource {

	public static void main(String[] args) {

		try {

			// String
			// filePath="D:\\workspace_formation_jasper\\MonProjet-Reporting-11-DataSourceXML\\reports\\AircraftData.xml";
			// InputStream inputStream = new FileInputStream(new File(filePath));
			// JRXmlDataSource xmlDataSource = new
			// JRXmlDataSource(inputStream,"/AircraftData/aircraft");
			
			JRXmlDataSource xmlDataSource = new JRXmlDataSource("reports/AircraftData.xml", "/AircraftData/aircraft");

			// Export du PDF
			JasperRunManager.runReportToPdfFile("reports/report-xml-with-description.jasper",
					"reports/report-xml-with-description.pdf", null, xmlDataSource);

		} catch (JRException  e) {
			e.printStackTrace();
		}
		System.out.println("Fin de la génération");
	}
}
