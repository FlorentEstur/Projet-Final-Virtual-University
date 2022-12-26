package org.mycompany.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.model.SupportCours;
import org.mycompany.repository.ISupportCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveToBDD implements Processor {
	@Autowired
	ISupportCoursRepository iscr;

	@Override
	public void process(Exchange exchange) throws Exception {
		SupportCours s2 = exchange.getIn().getBody(SupportCours.class);
		iscr.save(s2);
		System.out.println(exchange.getIn().getBody(SupportCours.class));
	}

}
