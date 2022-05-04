package gestiónCDs;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

	public static void main(String[] args) throws Exception {
		//file fichero = new File()
		String fichero = "cd_catalogue.xml";
		NodeList entry = abrirDocumento(fichero).getElementsByTagName(fichero);
		for (int i =0; i< entry.getLength(); i++) {
			if(entry.item(i).getNodeType()== Node.ELEMENT_NODE) {
				Element element = (Element) entry.item(i);
			}
			
			
		}
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
		//  metodo transform con una entrada y de entrega
		FileOutputStream fos = new FileOutputStream (fichero);
	
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		
		DOMSource s = new DOMSource(documentoXML);
		StreamResult r = new StreamResult(fos);
		t.transform(s,r);
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
