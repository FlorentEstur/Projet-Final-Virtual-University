package org.mycompany;

import java.util.Scanner;

import javax.jms.*;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.mycompany.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messagerie")
public class Messagerie {

	@Autowired
	ProducerTemplate producerTemplate;
	@Autowired
	ConsumerTemplate consumerTemplate;
	Scanner scan = new Scanner(System.in);
	int choix;
	
	@GetMapping("/question")
	public void question() {
		do {
			System.out.println("Posez votre question :");
			String question = scan.nextLine();
			producerTemplate.sendBody("direct:question", question);
			System.out.println("Avez vous d'autres questions ? Si oui taper 1 sinon taper autre chose.");
			choix = Integer.parseInt(scan.nextLine());
		} while (choix == 1);
	}
	
	@GetMapping("/reponse")
	public void reponse() {
		do {
			System.out.println("Envoyer votre réponse :");
			String reponse = scan.nextLine();
			producerTemplate.sendBody("direct:reponse", reponse);
			System.out.println("Avez vous d'autres réponses à émettre ? Si oui taper 1 sinon taper autre chose.");
			choix = Integer.parseInt(scan.nextLine());
		} while (choix == 1);
	}
	
	@GetMapping("/listenerQuestion")
	public void listenerQuestion() throws Exception {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://194.206.91.85:61616");
		Connection connection = connectionFactory.createConnection("admin", "adaming");
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("Florent_Question_Etudiant");
		MessageConsumer consumer = session.createConsumer(destination);
		
		consumer.setMessageListener(new Listener());
		Thread.sleep(10000);
		consumer.close();
	}
	
	@GetMapping("/listenerReponse")
	public void listenerReponse() throws Exception {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://194.206.91.85:61616");
		Connection connection = connectionFactory.createConnection("admin", "adaming");
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("Florent_Reponse_Prof");
		MessageConsumer consumer = session.createConsumer(destination);
		
		consumer.setMessageListener(new Listener());
		Thread.sleep(10000);
		consumer.close();
	}
}
