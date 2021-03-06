package M6_Project.Examen1;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;


@XmlRootElement (name="alumne")
public class Alumne implements Serializable{

	 String nom;
	 String cognoms;
	 String dni;
	 String adreca;
	 ArrayList<String> telefons = new ArrayList<String>();
	 ArrayList<String> mails = new ArrayList<String>();;
	
	
	
	public Alumne(String nom, String cognoms, String dNI, String adreca, ArrayList<String> telefons, ArrayList<String> mails) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		dni = dNI;
		this.adreca = adreca;
		this.telefons = telefons;
		this.mails = mails;
	}
	
	public Alumne() {
		super();
	}
	
	@XmlElement (name="nom")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElement (name="cognoms")
	public String getCognoms() {
		return cognoms;
	}
	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}
	@XmlElement (name="DNI")
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dNI) {
		dni = dNI;
	}
	@XmlElement (name="adreca")
	public String getAdreca() {
		return adreca;
	}
	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}
		@XmlElementWrapper(name = "telefons")
	@XmlElement(name="telefon")
	public ArrayList<String> getTelefons() {
		return telefons;
	}
	public void setTelefons(ArrayList<String> telefons) {
		this.telefons = telefons;
	}
	@XmlElementWrapper (name="mails")
	@XmlElement(name="mail")
	public ArrayList<String> getMail() {
		return mails;
	}
	public void setMail(ArrayList<String> mail) {
		this.mails = mail;
	}
	
	
	public String toString() {
		return nom;
	}
	
}
