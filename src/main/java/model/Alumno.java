package model;

public class Alumno {
	
	

	private String cod_alumno; 
	private String nombres; 
	private String ape_paterno;
	private String ape_materno; 
	private int documento ; 
	private String fecha_naci ; 
	private int edad; 
	private String nacionalidad;
	private String domicilio ;
	private int telefono; 
	private String sexo ; 
	private int id_apoderado ;
	private int estado_id_estado;
	
	
	@Override
	public String toString() {
		return "Alumno [cod_alumno=" + cod_alumno + ", nombres=" + nombres + ", ape_paterno=" + ape_paterno
				+ ", ape_materno=" + ape_materno + ", documento=" + documento + ", fecha_naci=" + fecha_naci + ", edad="
				+ edad + ", nacionalidad=" + nacionalidad + ", domicilio=" + domicilio + ", telefono=" + telefono
				+ ", sexo=" + sexo + ", id_apoderado=" + id_apoderado + ", estado_id_estado=" + estado_id_estado + "]";
	}


	public String getCod_alumno() {
		return cod_alumno;
	}


	public void setCod_alumno(String cod_alumno) {
		this.cod_alumno = cod_alumno;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApe_paterno() {
		return ape_paterno;
	}


	public void setApe_paterno(String ape_paterno) {
		this.ape_paterno = ape_paterno;
	}


	public String getApe_materno() {
		return ape_materno;
	}


	public void setApe_materno(String ape_materno) {
		this.ape_materno = ape_materno;
	}


	public int getDocumento() {
		return documento;
	}


	public void setDocumento(int documento) {
		this.documento = documento;
	}


	public String getFecha_naci() {
		return fecha_naci;
	}


	public void setFecha_naci(String fecha_naci) {
		this.fecha_naci = fecha_naci;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public int getId_apoderado() {
		return id_apoderado;
	}


	public void setId_apoderado(int id_apoderado) {
		this.id_apoderado = id_apoderado;
	}


	public int getEstado_id_estado() {
		return estado_id_estado;
	}


	public void setEstado_id_estado(int estado_id_estado) {
		this.estado_id_estado = estado_id_estado;
	}
	
	
	
	
	
	
	
	

}
