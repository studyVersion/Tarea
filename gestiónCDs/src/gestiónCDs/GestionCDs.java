package gestiónCDs;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface GestionCDs {
	
	public static final String title = "";
	public static final String artist = "";
	public static final String country = "";
	public static final String company = "";
	public static final Double price = null;
	public static final int year = 0;
	
	
	
	public static Document abrirDocumento(String fichero)throws Exception {
		return null;
	}
	public static  void guardarDocumento(String fichero, Document documentoXML) throws Exception {
	}
	public static Document cambiarElemento(Document documentoXML, Element elementoViejo, Element elementoNuevo) throws Exception {
		return null;
	}
	public static Document quitarElemento(Document documentoXML, Element elementoQuitar) {
		return null;
	}
	public Document añadirElemento(Document documentoXMl, Element elementoAñadir);
}
