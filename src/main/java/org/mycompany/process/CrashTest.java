package org.mycompany.process;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.model.ListeCours;
import org.mycompany.model.SupportCours;
import org.mycompany.repository.ISupportCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CrashTest implements Processor {
	@Autowired
	ISupportCoursRepository iscr;

	@Override
	public void process(Exchange exchange) throws Exception {
		JAXBContext context = JAXBContext.newInstance(ListeCours.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ListeCours listeCours = (ListeCours) unmarshaller.unmarshal(new File("TestTransfoListXML/ListCours.xml"));
		
		for (SupportCours s : listeCours.getListeCours()) {
			iscr.save(s);
		}
	}

}
