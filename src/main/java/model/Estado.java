package model;

public class Estado {

	private int idEst;
	private String desEst;
		
	@Override
	public String toString() {
		return "Estado [idEst=" + idEst + ", desEst=" + desEst + "]";
	}
	
	// Metodos de Acceso Set y Get
	
	public int getIdEst() {
		return idEst;
	}
	public void setIdEst(int idEst) {
		this.idEst = idEst;
	}
	public String getDesEst() {
		return desEst;
	}
	public void setDesEst(String desEst) {
		this.desEst = desEst;
	}
	
	
}
