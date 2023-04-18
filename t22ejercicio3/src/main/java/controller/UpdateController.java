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

/*
 * Controller for updating the info
 */
public class UpdateController implements ActionListener {

	private MainWindowView mainWindowView;
	private Scientist scientist;
	private Project project;
	private AssignedTo assignedTo;
	private Connection connWithMySQL;

	public UpdateController(MainWindowView main_window, Scientist scientist_model, Project project_model,
			AssignedTo assigned_to_model,Connection conn_with_MySql) {
		this.mainWindowView = main_window;
		this.scientist = scientist_model;
		this.project = project_model;
		this.assignedTo = assigned_to_model;
		this.connWithMySQL = conn_with_MySql;
		
		this.mainWindowView.getUpdateButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Get all the info from the view
		this.infoFromViewToModels();
		// Delete previous table
		// insert new values into table
		this.updateEntry();

	}

	/*
	 * Get info from GUI
	 */
	private void infoFromViewToModels() {
		this.scientist.setDNI(this.mainWindowView.getUpdateScientistDNI());
		this.scientist.setNomApels(this.mainWindowView.getUpdateNomApels());
		
		this.project.setIdProject(this.mainWindowView.getUpdateProjectId());
		this.project.setName(this.mainWindowView.getUpdateProjectName());
		this.project.setHours(this.mainWindowView.getUpdateProjectHours());
		
		this.assignedTo.setDNI(this.mainWindowView.getUpdateAssginedToDNI());
		this.assignedTo.setIdProject(this.mainWindowView.getUpdateAssignedToId());
	}
	
	/*
	 * Update the database
	 */
	private void updateEntry() {
		if (!this.scientist.getDNI().isEmpty()) {
			MySQLConnectionHandler.updateScientist(connWithMySQL, scientist);
		} else {
			System.out.println("Update no efectuado");
		}
		
		if (!this.project.getIdProject().isEmpty()) {
			MySQLConnectionHandler.updateProject(connWithMySQL, project);
		} else {
			System.out.println("Update no efectuado");
		}
		
		if (!this.assignedTo.getDNI().isEmpty() && !this.assignedTo.getProjectId().isEmpty()) {
			MySQLConnectionHandler.updateAssignedTo(connWithMySQL, assignedTo);
		} else {
			System.out.println("Update no efectuado");
		}
	}

}
