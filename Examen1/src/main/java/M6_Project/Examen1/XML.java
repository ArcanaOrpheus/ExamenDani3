package M6_Project.Examen1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class XML {
	 Institut ins = new Institut();
	
	 void read() {
		 
		try {  
			   
	        File file = new File("institut.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Institut.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        ins = (Institut) jaxbUnmarshaller.unmarshal(file);
	      
	      }
		
		catch (JAXBException e) {  
			
	        e.printStackTrace();  
	        
	      }
		
		
			
	}
	  void write(){
		 	
			try {
				
				JAXBContext contextObj = JAXBContext.newInstance(Institut.class);  
				Marshaller marshallerObj = contextObj.createMarshaller();  
				marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshallerObj.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

				FileOutputStream fos = new FileOutputStream("institut.xml");
				
					marshallerObj.marshal(ins, fos);
				
				
			} catch (FileNotFoundException | JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

	       
	} 
	 
	  void imprimirMails() {
		 read();
		 for(Alumne a : ins.alumnes) System.out.println(a.getMail());
		 write();
	 }
	 
		 public void afegeixContacte(String dniAlumne, String contacte) {
			 read();
			for(Alumne a : ins.getAlumnes()) {
				
				if(a.dni.equals(dniAlumne)) {
					
					if(contacte.contains("@")) 	a.mails.add(contacte);
					if(!contacte.contains("@")) a.telefons.add(contacte);
					
				}
			}
			write();
			
		}
	 
}
