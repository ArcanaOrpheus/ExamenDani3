package M6_Project.Examen1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XML2JSON {
	public static void main(String[] args) {
		createAlumne();
	}
	static Aules aula= new Aules();	
	static void createAula() {
		try {  
			   
	        File file = new File("aula.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Aules.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        aula = (Aules) jaxbUnmarshaller.unmarshal(file);
	        
	        JSONObject jo= new JSONObject();
	        jo.put("nom", aula.getNom());
	        jo.put("capacitat", aula.getCapacitat());
	        jo.put("aireacondicionat", aula.isAireacondicionat());
	        JSONArray array = new JSONArray();
	        for(Maquina m : aula.maquines) {
	        	JSONObject jo2= new JSONObject();
	        	jo2.put("nom", m.nom);
	        	jo2.put("processador", m.processador);
	        	jo2.put("grafica", m.grafica);
	        	array.add(jo2);
	        }
	        jo.put("maquines", array);
	       
	        FileWriter file2 = new FileWriter("aula.json");

	        file2.write(jo.toJSONString());
	        file2.flush();
	        
	      }
		catch (JAXBException e) {
			e.printStackTrace();  		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void createAlumne() {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("aula.json"));
			
			JSONObject aula = (JSONObject) obj;
			
			JSONArray maquines = (JSONArray) aula.get("maquines");
			ArrayList<Maquina> maquinaria = new ArrayList<Maquina>();
			for(Object o: maquines) {
				JSONObject meme = (JSONObject)o;
				Maquina mac= new Maquina((String)meme.get("nom"),(String) meme.get("processador"),(Boolean) meme.get("grafica"));
				maquinaria.add(mac);
			}
			
				Aules a = new Aules((String)aula.get("nom"),(Long) aula.get("capacitat"),(Boolean) aula.get("aireacondicionat"),maquinaria);
				write(a);
			
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	  static void write(Aules al){
		 	
			try {
				
				JAXBContext contextObj = JAXBContext.newInstance(Aules.class);  
				Marshaller marshallerObj = contextObj.createMarshaller();  
				marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshallerObj.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

				FileOutputStream fos = new FileOutputStream("aules.xml");
				
					marshallerObj.marshal(al, fos);
				
				
			} catch (FileNotFoundException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

	       
	} 
}


