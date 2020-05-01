package ufv.dis.parcialfinal.RSRS;

import java.util.ArrayList;

import ufv.dis.parcialfinal.RSRS.*;;

public class Lista {

	private ArrayList<Usuario> objetos;
	
	//creo mi constructor donde instancio el array
	public Lista() {
		
		this.objetos = new ArrayList<Usuario>();
		
	}
	//voy a crear un metodo que va a ser para añadir objetos
	public void addObjeto(Usuario u) {
		
		this.objetos.add(u);
		
	}
	
	//otro metodo que me devuelve un arraylist de los objetos
	public ArrayList<Usuario> getObjetos() {
		
		return this.objetos;
	}
	
	//otro metodo para que me devuelva el total de los objetos
	public int totalUsuarios() {
		
		return this.objetos.size();
		
	}
}
