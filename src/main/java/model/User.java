package model;

public class User {

	private int codUs;
	private String nomUs;
	private String pasUs;
	private String rolUs;
	private String codEm;
	private String estadoId;
	
	@Override
	public String toString() {
		return "User [codUs=" + codUs + ", nomUs=" + nomUs + ", pasUs=" + pasUs + ", rolUs=" + rolUs + ", codEm="
				+ codEm + ", estadoId=" + estadoId + "]";
	}

	public int getCodUs() {
		return codUs;
	}

	public void setCodUs(int codUs) {
		this.codUs = codUs;
	}

	public String getNomUs() {
		return nomUs;
	}

	public void setNomUs(String nomUs) {
		this.nomUs = nomUs;
	}

	public String getPasUs() {
		return pasUs;
	}

	public void setPasUs(String pasUs) {
		this.pasUs = pasUs;
	}

	public String getRolUs() {
		return rolUs;
	}

	public void setRolUs(String rolUs) {
		this.rolUs = rolUs;
	}

	public String getCodEm() {
		return codEm;
	}

	public void setCodEm(String codEm) {
		this.codEm = codEm;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}
	
	
	
}
