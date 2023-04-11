package models;

public class AssignedTo {
	
	private String DNI;
	private String idProject;

	public AssignedTo() {
		this.DNI = "";
		this.idProject = "";
	}

	public String getDNI() {
		return DNI;
	}

	public String getNomApels() {
		return idProject;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNomApels(String nomApels) {
		this.idProject = nomApels;
	}
}
