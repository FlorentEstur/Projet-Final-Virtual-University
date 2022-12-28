package org.mycompany.process;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.model.Cours;
import org.mycompany.model.ListeCours;
import org.mycompany.model.ListeCoursEtudiants;
import org.mycompany.repository.ICoursRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessInsert implements Processor {

	@Autowired
	ICoursRepository icoursRepository;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		JAXBContext context = JAXBContext.newInstance(ListeCours.class);
		Unmarshaller unmasrheller = context.createUnmarshaller();
		ListeCoursEtudiants listeCoursEtudiants = (ListeCoursEtudiants) unmasrheller.unmarshal(new File("ListeCours/ListeCours.xml"));
		
		for (Cours cours : listeCoursEtudiants.getListeCoursEtudiant()) {
			icoursRepository.save(cours);
		}
			
		
	
}
}