package ufv.dis.parcialfinal.RSRS;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import ufv.dis.parcialfinal.RSRS.*;

import com.itextpdf.text.DocumentException;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	//añado el inventario
    	Lista lista = new Lista();
    	
    	//layout vertical de recogida de datos
    	final VerticalLayout vlayout = new VerticalLayout();
    	
    	//layout vertical de mostrar datos
        final VerticalLayout vlayout2 = new VerticalLayout();
        
        //layout horizontal que engloba a los dos verticales
        final HorizontalLayout hlayout = new HorizontalLayout();
        
        final TextField nombre = new TextField();
        nombre.setCaption("Nombre: ");
        
        final TextField apellidos = new TextField();
        apellidos.setCaption("Apellidos: ");
        
        final TextField email = new TextField();
        email.setCaption("Email: ");
        
        final TextField dni = new TextField();
        dni.setCaption("DNI: ");
        
        final TextField fechaNacimiento = new TextField();
        fechaNacimiento.setCaption("Fecha de Nacimiento: ");
        
        final TextField edad = new TextField();
        edad.setCaption("Edad: ");
        
        //array para numero de tweet
        ArrayList<Integer> numerousuario= new ArrayList<>();
        
        
        //creamos una tabla con sus items y columnas
        Grid<Usuario> grid = new Grid<>();
        grid.setItems(lista.getObjetos());
        grid.addColumn(Usuario::getNombre).setCaption("Nombre");
        grid.addColumn(Usuario::getApellidos).setCaption("Apellidos");
        grid.addColumn(Usuario::getEmail).setCaption("Email");
        grid.addColumn(Usuario::getDNI).setCaption("DNI");
        grid.addColumn(Usuario::getFechaNacimiento).setCaption("Fecha nacimiento");
        grid.addColumn(Usuario::getEdad).setCaption("Edad");
        grid.setCaption("Tabla de usuarios: ");

        Button button = new Button("Añadir usuario");
        button.addClickListener(e -> {
        	// Comprobamos si los textfield estan vacios
			if (nombre.getValue().isEmpty() || apellidos.getValue().isEmpty() || email.getValue().isEmpty() || dni.getValue().isEmpty() || fechaNacimiento.getValue().isEmpty() || edad.getValue().isEmpty()){
	        	Notification.show("No se puede añadir el usuario, ya que faltan datos... ", Notification.Type.HUMANIZED_MESSAGE).setDelayMsec(3000);        	
			}
			else  {
				numerousuario.add(1);
				//String fechastr = date.getValue().toString();
				Usuario usuario = new Usuario(nombre.getValue(), apellidos.getValue(), email.getValue(), dni.getValue(), fechaNacimiento.getValue(), Integer.parseInt(edad.getValue())); //se importa la libreria tweet
	        	lista.addObjeto(usuario);
	        	grid.setItems(lista.getObjetos()); //para que cuando se añada un nuevo objeto se vuelva a crear/actualizar la tabla
	        	
	        	//como GeneradorPDF era un metodo estatico, no lo he tenido que instanciar y como da un error, hago un try catch
	        	//debido a que como añadimos un throw con una excepcion de que si no funciona lance la excepcion
	        	try {
					GeneradorPDF.generarPDF(usuario);
					Notification.show("Usuario añadido correctamente y PDF generado.", Notification.Type.HUMANIZED_MESSAGE).setDelayMsec(3000);
				} catch (FileNotFoundException | DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 
    
				nombre.clear();
				apellidos.clear();
				email.clear();
				dni.clear();
				fechaNacimiento.clear();
				edad.clear();
			}
        });
              
        vlayout.addComponents(nombre, apellidos, email, dni, fechaNacimiento, edad, button);
        hlayout.addComponents(vlayout, grid);
        
        setContent(hlayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
