package ufv.dis.parcialfinal.RSRS;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneradorPDF {

	public static void generarPDF(Usuario usuario) throws FileNotFoundException, DocumentException
	{

		//String filename = "fichero.pdf";
		String filename = "pdfs/" + usuario.getNombre() + "-" + usuario.getApellidos() + ".pdf";
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		document.open();
		document.add(new Paragraph("Nombre: " + usuario.getNombre()));
		document.add(new Paragraph("Apellidos: " + usuario.getApellidos()));
		document.add(new Paragraph("Email: " + usuario.getEmail()));
		document.add(new Paragraph("DNI: " + usuario.getDNI()));
		document.add(new Paragraph("Fecha de nacimiento: " + usuario.getFechaNacimiento()));
		document.add(new Paragraph("Edad: " + usuario.getEdad()));
		
		document.add(new Paragraph("¿Es un adulto?: " + usuario.isAdult()));
		document.add(new Paragraph(new Date().toString()));
		
		document.close();

	}
}
