package M6_Project.Examen1;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GatSerialitzat {
	
	public static void main(String[] args) {
		testArray();
		readSerializableArray();
	}
	
	static void readSerializable() {
		try {
			ArrayList<Gat> gatetes = new ArrayList<Gat>();
			File f = new File("lel.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				while (true) {
					Object o = ois.readObject() ;
					Gat gatete = new Gat((Gat) o);
					gatetes.add(gatete);
				}
			}
			 catch (EOFException fin) {
				ois.close();
			}
			FileWriter fw = new FileWriter("gat.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for(Gat g: gatetes) {
				String s= g.toString();
				bw.write(s);
			}
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	static void readSerializableArray() {
		try {
			ArrayList<Gat> gatetes = new ArrayList<Gat>();
			File f = new File("lels.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				while (true) {
					Object o2 = ois.readObject();
					gatetes.addAll((ArrayList<Gat>) o2);
				}
			}
			 catch (EOFException fin) {
				ois.close();
			}
			FileWriter fw = new FileWriter("gats.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for(Gat g: gatetes) {
				System.out.println("hola");
				String s= g.toString();
				bw.write(s);
			}
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static void test() {
		try {
			File f = new File("lel.dat");
			FileOutputStream fol = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fol);
			Gat gat = new Gat("jojo","dio",1,"comida",false);
			oos.writeObject(gat);
			
			
		} catch (Exception e) {
		}
	}
	
	static void testArray() {
		try {
			File f = new File("lels.dat");
			FileOutputStream fol = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fol);
		ArrayList<Gat> gatetes = new ArrayList<Gat>();
		Gat gat = new Gat("jojo","dio",1,"comida",false);
		Gat gat2 = new Gat("jojo","dio",1,"comida",false);
		Gat gat3= new Gat("jojo","dio",1,"comida",false);
		Gat gat4 = new Gat("jojo","dio",1,"comida",false);
		Gat gat5 = new Gat("jojo","dio",1,"comida",false);
		gatetes.add(gat);
		gatetes.add(gat2);
		gatetes.add(gat3);
		gatetes.add(gat4);
		gatetes.add(gat5);
		oos.writeObject(gatetes);
		
		
	} catch (Exception e) {
	}
	}
}
