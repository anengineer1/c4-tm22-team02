package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.AssignedTo;
import models.Project;
import models.Scientist;
import utils.MySQLConnectionHandler;
import views.MainWindowView;

public class LookUpControllerAssignedTo implements ActionListener {

	private MainWindowView mainWindowView;
	private Scientist scientist;
	private Project project;
	private AssignedTo assignedTo;
	private Connection connWithMySQL;

	public LookUpControllerAssignedTo(MainWindowView main_window, Scientist scientist_model, Project project_model,
			AssignedTo assigned_to_model,Connection conn_with_MySql) {
		this.mainWindowView = main_window;
		this.scientist = scientist_model;
		this.project = project_model;
		this.assignedTo = assigned_to_model;
		this.connWithMySQL = conn_with_MySql;
		
		this.mainWindowView.getLookUpAssignedToButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Get all the info from the view
		this.infoFromViewToModels();
		// Delete previous table
		this.clearRows();
		// insert new values into table
		this.lookIntoDb();

	}

	private void infoFromViewToModels() {
		this.scientist.setDNI(this.mainWindowView.getLookUpScientistDNI());
		this.scientist.setNomApels(this.mainWindowView.getLookUpScientistNomApels());
		
		this.project.setIdProject(this.mainWindowView.getLookUpProjectId());
		this.project.setName(this.mainWindowView.getLookUpProjectName());
		this.project.setHours(this.mainWindowView.getLookUpProjectHours());
		
		this.assignedTo.setDNI(this.mainWindowView.getLookUpScientistDNI());
		this.assignedTo.setIdProject(this.mainWindowView.getLookUpProjectId());
	}
	
	
	private void lookIntoDb() { // TODO: Make it work look up

		ResultSet rs = MySQLConnectionHandler.lookUpAssignedToData(this.connWithMySQL, this.assignedTo);
		try {
			while (rs.next()) {
				String dni = rs.getString("DNI");
				String id = rs.getString("Id");
				this.mainWindowView.setAssignedToRow(dni, id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void clearRows() {
		this.mainWindowView.clearRows();
	}


}
