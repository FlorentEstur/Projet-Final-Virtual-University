package org.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Entity
@Table (name="Cours_Projet")
@XmlRootElement(name ="Cours")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Cours {
	
	@XmlAttribute
	@Id
	private int id;
	private String matière;
	private String Enseignant;
	
	public Cours() {
		super();
	}

	public Cours(int id, String matière, String enseignant) {
		super();
		this.id = id;
		this.matière = matière;
		Enseignant = enseignant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatière() {
		return matière;
	}

	public void setMatière(String matière) {
		this.matière = matière;
	}

	public String getEnseignant() {
		return Enseignant;
	}

	public void setEnseignant(String enseignant) {
		Enseignant = enseignant;
	}

	@Override
	public String toString() {
		return "Cours [id=" + id + ", matière=" + matière + ", Enseignant=" + Enseignant + "]";
	}
	
	
	

}
