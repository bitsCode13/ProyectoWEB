package model;

public class Apoderado {
	private int codigo;
	private String descripcion;
	private String nombre;
	private String apellido;
	private int dni;
	private int telefono;
	private String domicilio;
	
	
	
	
	
	@Override
	public String toString() {
		return "Apoderado [codigo=" + codigo + ", descripcion=" + descripcion + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + ", telefono=" + telefono + ", domicilio=" + domicilio + "]";
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	
}
