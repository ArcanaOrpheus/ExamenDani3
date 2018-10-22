package M6_Project.Examen1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement (name="maquina")
public class Maquina implements Serializable{

	String nom;
	String processador;
	boolean grafica;
	
	public Maquina(String nom, String processador, boolean grafica) {
		super();
		this.nom = nom;
		this.processador = processador;
		this.grafica = grafica;
	}

	public Maquina() {
		super();
	}
	@XmlElement (name="maquina")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElement (name="processador")
	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}
	@XmlElement (name="grafica")
	public boolean isGrafica() {
		return grafica;
	}

	public void setGrafica(boolean grafica) {
		this.grafica = grafica;
	}
	
	
}
