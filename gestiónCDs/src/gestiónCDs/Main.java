package gestiónCDs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main implements GestionCDs {
	static String fichero = "cd_catalogue.xml";
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("1. abrir Documento");
		System.out.println("1. cambiar Elemento");
		System.out.println("1. Guardar Ducumento");
		//System.out.println("1. abrir Documento");
		 
		Document file = abrirDocumento(fichero);
		Element elemento1 = null;
		Element elemento2 = null;
		while(true) {
			int option =Integer.parseInt(sc.nextLine());
	    switch (option) {
	       
	       case 1 : file = abrirDocumento(fichero);break;
	       case 2 : System.out.println("Type the name of the Element to change");
                    String elementV = sc.nextLine().trim();
                    System.out.println("Type the name: ");
                    String elementN = sc.nextLine().trim();
                    NodeList cambiarLista = file.getElementsByTagName(elementV);    
                    for(int i= 0; i<cambiarLista.getLength();i++) {
                    	elemento1 = (Element) cambiarLista.item(i);
                    	elemento2 = file.createElement(elementN);
                    }
                    /*elemento1= file.createElement(elementV);
			        elemento2 = file.createElement(elementN);*/
	    			file = cambiarElemento (file,elemento1,elemento2);break;
	       
	       case 3 :	System.out.println("Type the name of the Element to remove");
                    String elementR = sc.nextLine().trim();		
                    NodeList element = file.getElementsByTagName(elementR);             // quitarElemento
	                for(int i=0; i< element.getLength(); i++) {
	                	elemento1 = (Element)element.item(i);
	                }
	                file= quitarElemento(file,elemento1);
	                
	       case 4 : System.out.println("Type the name of the Element to add");      
	                String elementADD = sc.nextLine().trim();	
	                NodeList añadir = file.getElementsByTagName("CD"); 
	                for(int i=0; i< añadir.getLength(); i++) {
	                	  elemento1 = file.createElement(elementADD );
	              
	                }
	       case 5 : guardarDocumento(fichero,file);
		}
		
		}	
		}
	

	
	public static Document abrirDocumento(String fichero) throws Exception {
		// reciebe cadena con el nombre ruta al fichero .xml
	   // devuelve un objecto Document
	   // necesito DocumentBuilder para hacer el parse
		
		DocumentBuilder leerFichero = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    Document documentoXML = leerFichero.parse(fichero);
	   
	   
		return documentoXML;
	}//main

	
	public static void guardarDocumento(String fichero, Document documentoXML) throws Exception {
		 // stream de salida a un fichero
		 // transformer de transformerfactory
		//  metodo transform con una entrada y de entrega
		FileOutputStream fos = new FileOutputStream (fichero);
	
		TransformerFactory tf = TransformerFactory.newInstance();
		
		Transformer t = tf.newTransformer();
		
		t.setOutputProperty(OutputKeys.INDENT,"yes" );
		
		DOMSource s = new DOMSource(documentoXML);
		StreamResult r = new StreamResult(fos);
		
		t.transform(s,r);
	}


	public static Document cambiarElemento(Document documentoXML, Element elementoViejo, Element elementoNuevo) throws Exception {
		FileInputStream input = new FileInputStream(fichero);
		NodeList listaCDs = documentoXML.getElementsByTagName("CD");
		
		for (int i =0; i< listaCDs.getLength(); i++) { 
			// grabar el node CD
			
				Node CD = listaCDs.item(i);
				
				if(CD.getNodeType()== Node.ELEMENT_NODE) {
					
					NodeList hijosCD = CD.getChildNodes();
					
					for(int j =0; j < hijosCD.getLength(); j++) {
                        Node hijo =  hijosCD.item(i);
                        if(hijo.getNodeType()== Node.ELEMENT_NODE) {
                      // System.out.println(hijo.getNodeName());
                      // Element viejo =  elementoViejo;
                      // Element nuevo =  elementoNuevo;
						
						if(elementoViejo.getNodeName().equalsIgnoreCase(hijo.getNodeName())) {
							String text = hijo.getTextContent();
							/*String text = hijo.getTextContent();
							CD.removeChild(hijo);
							elementoNuevo.appendChild(documentoXML.createTextNode(text));
							//elementoNuevo.setTextContent(text);
							CD.appendChild(elementoNuevo);*/
							Node a = (Node)elementoNuevo;
							CD.replaceChild(hijo, a);
						}   
						}
					}
				}
			}
			
		
		return documentoXML;
	}

	
	public static Document quitarElemento(Document docXML, Element elementoQuitar) {
		NodeList lista = docXML.getElementsByTagName("CD");
		
		for(int i=0; i< lista.getLength(); i++) {
			Node CD = lista.item(i);                // get lista items
		  	if(CD.getNodeType() == Node.ELEMENT_NODE){
		  		NodeList hijosCD = CD.getChildNodes();
		  		 
		  		  for (int j=0; j<hijosCD.getLength(); j++) {
		  			  Node hijo = hijosCD.item(j);
		  			    if(hijo.getNodeType()== Node.ELEMENT_NODE) {
		  			    	if (elementoQuitar.getNodeName().equalsIgnoreCase(hijo.getNodeName())) {
		  			    		CD.removeChild(hijo);
		  			    	}
		  			    }
		  		  }
		  	}
		}
		return docXML;
	}


	public Document añadirElemento(Document docXML, Element elementoAñadir) {
            NodeList lista = docXML.getElementsByTagName("CD");
		
		for(int i=0; i< lista.getLength(); i++) {
			Node CD = lista.item(i);                // get lista items
		  	if(CD.getNodeType() == Node.ELEMENT_NODE){
		  		NodeList hijosCD = CD.getChildNodes();
		  		 
		  		  for (int j=0; j<hijosCD.getLength(); j++) {
		  			  Node hijo = hijosCD.item(j);
		  			    if(hijo.getNodeType()== Node.ELEMENT_NODE) {
		  			    	if (elementoAñadir.getNodeName().equalsIgnoreCase(hijo.getNodeName())) {
		  			    		
		  			    		System.out.println("Type the element text");
		  			    		String a = sc.nextLine();
	  			    		elementoAñadir.appendChild(docXML.createTextNode(a));
		                        staff.appendChild(salary);
		  			    	}
		  			    }
		  		  }
		  	}
		}
		return null;
	}

}
