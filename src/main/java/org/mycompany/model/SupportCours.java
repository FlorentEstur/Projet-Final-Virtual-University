package org.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Entity
@Table
@XmlRootElement(name = "cours")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupportCours {

	@Id
	private String id_matiere;
	private String id_cours, titre, enseignant;
	private String support;
	
	public SupportCours() {
		super();
	}

	public SupportCours(String idMatiere, String idCours, String titre, String enseignant, String support) {
		super();
		this.id_matiere = idMatiere;
		this.id_cours = idCours;
		this.titre = titre;
		this.enseignant = enseignant;
		this.support = support;
	}

	public String getIdMatiere() {
		return id_matiere;
	}

	public void setIdMatiere(String idMatiere) {
		this.id_matiere = idMatiere;
	}

	public String getIdCours() {
		return id_cours;
	}

	public void setIdCours(String idCours) {
		this.id_cours = idCours;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	@Override
	public String toString() {
		return "SupportCours [idMatiere=" + id_matiere + ", idCours=" + id_cours + ", titre=" + titre + ", enseignant="
				+ enseignant + ", support=" + support + "]";
	}
	
	
}
