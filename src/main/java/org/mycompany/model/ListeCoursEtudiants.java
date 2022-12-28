package org.mycompany.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="ListeCours")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListeCoursEtudiants {
	
	@XmlElement(name="Cours")
	private List<Cours> listeCoursEtudiant;

	public ListeCoursEtudiants() {
		super();
	}

	public ListeCoursEtudiants(List<Cours> listeCoursEtudiant) {
		super();
		this.listeCoursEtudiant = listeCoursEtudiant;
	}

	public List<Cours> getListeCoursEtudiant() {
		return listeCoursEtudiant;
	}

	public void setListeCoursEtudiant(List<Cours> listeCoursEtudiant) {
		this.listeCoursEtudiant = listeCoursEtudiant;
	}

	@Override
	public String toString() {
		return "ListeCoursEtudiants [listeCoursEtudiant=" + listeCoursEtudiant + "]";
	}

	


}
