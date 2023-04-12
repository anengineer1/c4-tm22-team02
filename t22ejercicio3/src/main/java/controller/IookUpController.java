package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import models.AssignedTo;
import models.Project;
import models.Scientist;
import utils.MySQLConnectionHandler;
import views.MainWindowView;

public class IookUpController implements ActionListener {

	private MainWindowView mainWindowView;
	private Scientist scientist;
	private Project project;
	private AssignedTo assignedTo;
	private Connection connWithMySQL;

	public IookUpController(MainWindowView main_window, Scientist scientist_model, Project project_model,
			AssignedTo assigned_to_model,Connection conn_with_MySql) {
		this.mainWindowView = main_window;
		this.scientist = scientist_model;
		this.project = project_model;
		this.assignedTo = assigned_to_model;
		this.connWithMySQL = conn_with_MySql;
		
		this.mainWindowView.getLookUpButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Get all the info from the view
		this.infoFromViewToModels();
		this.lookIntoDb();

	}

	private void infoFromViewToModels() {
		this.scientist.setDNI(this.mainWindowView.getLookUpScientistView().getScientistDNI());
		this.scientist.setNomApels(this.mainWindowView.getLookUpScientistView().getNomApels());
		
		this.project.setIdProject(this.mainWindowView.getLookUpProjectView().getIdProject());
		this.project.setName(this.mainWindowView.getLookUpProjectView().getProjectName());
		this.project.setHours(this.mainWindowView.getLookUpProjectView().getHours());
		
		this.assignedTo.setDNI(this.mainWindowView.getLookUpScientistProject().getScientistDNI());
		this.assignedTo.setIdProject(this.mainWindowView.getLookUpScientistProject().getProjectId());
	}
	
	
	private void lookIntoDb() { // TODO: Make it work look up

		ResultSet rs = MySQLConnectionHandler.lookUpData(this.connWithMySQL, this.scientist, this.project, this.assignedTo);
		this.mainWindowView.getLookUpView().setResults(rs.toString());
	}


}
