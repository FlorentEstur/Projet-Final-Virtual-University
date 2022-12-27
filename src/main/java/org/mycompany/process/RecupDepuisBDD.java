package org.mycompany.process;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.model.ListeCours;
import org.mycompany.model.SupportCours;
import org.mycompany.repository.ISupportCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recup")
public class RecupDepuisBDD {

	@Autowired
	ISupportCoursRepository iscr;
	
	@GetMapping("/BDDToXML")
	public List<SupportCours> getCoursFromBDD()  throws Exception {
		JAXBContext context = JAXBContext.newInstance(ListeCours.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		ListeCours liste = new ListeCours();
		
		liste.setListeCours(iscr.findAll());
		
		marshaller.marshal(liste, new File("ListeCoursGenerated.xml"));
		
		return liste.getListeCours();
	}

}
