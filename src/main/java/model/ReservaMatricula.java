package model;

public class ReservaMatricula {
	
	private int idRes;
	private String codRes;
	private String fecReg;
	private double cueRes;
	private String codAlu;
	private int idEst;
	
	
	@Override
	public String toString() {
		return "ReservaMatricula [idRes=" + idRes + ", codRes=" + codRes + ", fecReg=" + fecReg + ", cueRes=" + cueRes
				+ ", codAlu=" + codAlu + ", idEst=" + idEst + "]";
	}
	
	// Metodos de acceso Set y Get
	
	public int getIdRes() {
		return idRes;
	}
	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}
	public String getCodRes() {
		return codRes;
	}
	public void setCodRes(String codRes) {
		this.codRes = codRes;
	}
	public String getFecReg() {
		return fecReg;
	}
	public void setFecReg(String fecReg) {
		this.fecReg = fecReg;
	}
	public double getCueRes() {
		return cueRes;
	}
	public void setCueRes(double cueRes) {
		this.cueRes = cueRes;
	}
	public String getCodAlu() {
		return codAlu;
	}
	public void setCodAlu(String codAlu) {
		this.codAlu = codAlu;
	}
	public int getIdEst() {
		return idEst;
	}
	public void setIdEst(int idEst) {
		this.idEst = idEst;
	}
	
	
	
	

}
