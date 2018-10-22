package M6_Project.Examen1;

import java.io.Serializable;

public class Gat implements Serializable{
	
	String nom;
	String raza;
	int edat;
	String menjarPreferit;
	boolean capat;

	
	public Gat(String nom, String raza, int edat, String menjarPreferit, boolean capat) {
		super();
		this.nom = nom;
		this.raza = raza;
		this.edat = edat;
		this.menjarPreferit = menjarPreferit;
		this.capat = capat;
	}
	
	public Gat(Gat gat) {
		super();
		this.nom = gat.nom;
		this.raza = gat.raza;
		this.edat = gat.edat;
		this.menjarPreferit = gat.menjarPreferit;
		this.capat = gat.capat;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public String getMenjarPreferit() {
		return menjarPreferit;
	}

	public void setMenjarPreferit(String menjarPreferit) {
		this.menjarPreferit = menjarPreferit;
	}

	public boolean isCapat() {
		return capat;
	}

	public void setCapat(boolean capat) {
		this.capat = capat;
	}

	public String toString() {
		return "Gat [nom=" + nom + ", raza=" + raza + ", edat=" + edat + ", menjarPreferit=" + menjarPreferit
				+ ", capat=" + capat + "]";
	}
	

}
