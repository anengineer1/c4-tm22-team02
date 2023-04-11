package models;

public class Scientist {
	
	private String DNI;
	private String nomApels;

	public Scientist() {
		this.DNI = "";
		this.nomApels = "";
	}

	public String getDNI() {
		return DNI;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}
}
