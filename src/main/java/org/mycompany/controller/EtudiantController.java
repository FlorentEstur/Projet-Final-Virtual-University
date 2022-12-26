package org.mycompany.controller;

import java.util.List;

import org.mycompany.model.Cours;
import org.mycompany.repository.ICoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController {

	@Autowired
	ICoursRepository iCoursRepository;
	
	@GetMapping("/listeMatière")
	public List<Cours> listeCours()
	{
		return iCoursRepository.findAll();
	}
	
//	@GetMapping ("/listeEnseignant")
//	public List<Cours> listeEnseignant()
//	{
//		return iCoursRepository.listeEnseignant();
//	}
}
