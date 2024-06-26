package ufv.dis.parcialfinal.RSRS;

public class Usuario {

	private String Nombre;
	private String Apellidos;
	private String Email;
	private String DNI;
	private String FechaNacimiento;
	private int Edad;
	
	
	public Usuario(String nombre, String apellidos, String email, String dNI, String fechaNacimiento, int edad) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Email = email;
		DNI = dNI;
		FechaNacimiento = fechaNacimiento;
		Edad = edad;
	}
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	
	public boolean isAdult() {
		return Edad >= 18;
	}
}
