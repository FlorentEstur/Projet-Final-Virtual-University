package org.mycompany.process;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.model.SupportCours;
import org.mycompany.repository.ISupportCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JaxBUnmarshallBDD implements Processor {

	@Autowired
	ISupportCoursRepository iscr;

	@Override
	public void process(Exchange exchange) throws Exception {

		JAXBContext context = JAXBContext.newInstance(SupportCours.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		SupportCours s1 = (SupportCours) unmarshaller.unmarshal(new File("TestTransfoXML/Support-test.xml"));
		iscr.save(s1);
	}

}
