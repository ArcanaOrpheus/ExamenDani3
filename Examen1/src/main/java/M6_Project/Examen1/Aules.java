package M6_Project.Examen1;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name="aula")
public class Aules implements Serializable{
	String nom;
	int capacitat;
	boolean aireacondicionat;
	ArrayList <Maquina> maquines = new ArrayList<Maquina>();
	
	Aules(Aules aules){
		this.nom=nom;
		this.capacitat=capacitat;
		this.aireacondicionat=aireacondicionat;
		this.maquines.addAll(maquines);
	}
	
	public Aules(String nom, int capacitat, boolean aireacondicionat, ArrayList<Maquina> maquines) {
		super();
		this.nom = nom;
		this.capacitat = capacitat;
		this.aireacondicionat = aireacondicionat;
		this.maquines = maquines;
	}
	public Aules(String string, Long long1, Boolean boolean1, ArrayList<Maquina> arrayList) {
		super();
		this.nom = string;
		this.capacitat = Math.toIntExact(long1);
		this.aireacondicionat = boolean1;
		this.maquines = arrayList;
	}
	
	@XmlElement (name="nom")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElement (name="capacitat")
	public int getCapacitat() {
		return capacitat;
	}
	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}
	@XmlElement (name="aireacondicionat")
	public boolean isAireacondicionat() {
		return aireacondicionat;
	}
	public void setAireacondicionat(boolean aireacondicionat) {
		this.aireacondicionat = aireacondicionat;
	}
	@XmlElementWrapper(name = "maquines")
	@XmlElement(name="maquina")
	public ArrayList<Maquina> getMaquines() {
		return maquines;
	}
	public void setMaquines(ArrayList<Maquina> maquines) {
		this.maquines = maquines;
	}
	public Aules() {
		super();
	}

	

	public String toString() {
		return "Aula [nom=" + nom + ", capacitat=" + capacitat + ", aireacondicionat=" + aireacondicionat
				+ ", maquines=" + maquines + "]";
	} 
	
	
}
