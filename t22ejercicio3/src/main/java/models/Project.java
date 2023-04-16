package models;

public class Project {

	private String IdProject;
	private String name;
	// private int hours;
	private String hours;

	public Project() {
		this.IdProject = "";
		this.name = "";
		this.hours = "0";
	}

	public String getIdProject() {
		return IdProject;
	}

	public String getName() {
		return name;
	}

	public String getHours() {
		return hours;
	}

	public void setIdProject(String idProject) {
		IdProject = idProject;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setHours(String hours) {
		this.hours = hours;
	}

//	public int setHours(String hours) {
//		this.hours = -1;
//		try {
//		    this.hours =  Integer.parseInt(hours);
//		} catch (NumberFormatException e) {
//		    System.out.println("Error: could not parse string as int.");
//		}
//		return this.hours;
//	}
}
