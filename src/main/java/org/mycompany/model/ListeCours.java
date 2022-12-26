package org.mycompany.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "liste_cours")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListeCours {

	@XmlElement(name="cours")
	private List<SupportCours> listeCours;

	public ListeCours() {
		super();
	}

	public ListeCours(List<SupportCours> listeCours) {
		super();
		this.listeCours = listeCours;
	}

	public List<SupportCours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<SupportCours> listeCours) {
		this.listeCours = listeCours;
	}

	@Override
	public String toString() {
		return "ListeCours [listeCours=" + listeCours + "]";
	}
}
