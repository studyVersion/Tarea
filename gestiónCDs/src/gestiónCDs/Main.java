package gestiónCDs;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main implements GestionCDs {

	public static void main(String[] args) throws Exception {
		String fichero = "cd_catalogue.xml";
		abrirDocumento(fichero).getChildNodes();
		
	}

	
	public static Document abrirDocumento(String fichero) throws Exception {
		// reciebe cadena con el nombre ruta al fichero .xml
	   //devuelve un objecto Document
	   // necesito DocumentBuilder para hacer el parse
		
		DocumentBuilder leerFichero = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    Document documentoXML = leerFichero.parse(fichero);
	    
		return documentoXML;
	}//main

	
	public void guardarDocumento(String fichero, Document documentoXML) throws Exception {
		 // stream de salida a un fichero
		 // transformer de transformerfactory
		//  metodo transform con una entrada y 
	}


	public Document cambiarElemento(Document documentoXML, Element elementoViejo, Element elementoNuevo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Document quitarElemento(Document documentoXML, Element elementoQuitar) {
		// TODO Auto-generated method stub
		return null;
	}


	public Document añadirElemento(Document documentoXMl, Element elementoAñadir) {
		// TODO Auto-generated method stub
		return null;
	}

}
