package ufv.dis.parcialfinal.RSRS;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUsuarios {

	//instanciar usuario
	@Test
	public void instanciarUsuario() {
		Usuario usuario = new Usuario("Rocío", "Sosa", "rociioo@gmail.com", "51191157", "07101998", 21);
		assertEquals("Rocío", usuario.getNombre());
	}
	
	//añadir usuario a la lista
	@Test
	public void addUsuarioLista() {
		Usuario usuario = new Usuario("Rocío", "Sosa", "rociioo@gmail.com", "51191157", "07101998", 21);
		Lista lista = new Lista();
		lista.addObjeto(usuario);
		
		assertEquals(1, lista.totalUsuarios());
	}
	 
	//Comprobar mayoria de edad, tanto con un false como con un true
	@Test
	public void comprobarMayoriaEdad() {
		Usuario usuario = new Usuario("Rocío", "Sosa", "rociioo@gmail.com", "51191157", "07101998", 21);
		assertEquals(true, usuario.isAdult());
		
		Usuario usuario2 = new Usuario("Alvaro", "Sosa", "alvaro@gmail.com", "51191157", "07101998", 15);
		assertEquals(false, usuario2.isAdult());	
	}

}
