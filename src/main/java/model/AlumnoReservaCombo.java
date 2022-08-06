package model;

public class AlumnoReservaCombo {
	
	private String codAlu;
	private String nomAlu;
	
	@Override
	public String toString() {
		return "AlumnoReservaCombo [codAlu=" + codAlu + ", nomAlu=" + nomAlu + "]";
	}
	
	// Metodos de acceso Set y Get
	
	public String getCodAlu() {
		return codAlu;
	}
	public void setCodAlu(String codAlu) {
		this.codAlu = codAlu;
	}
	public String getNomAlu() {
		return nomAlu;
	}
	public void setNomAlu(String nomAlu) {
		this.nomAlu = nomAlu;
	}
	
	

}
