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

public class DeleteController implements ActionListener {

	private MainWindowView mainWindowView;
	private Scientist scientist;
	private Project project;
	private AssignedTo assignedTo;
	private Connection connWithMySQL;

	public DeleteController(MainWindowView main_window, Scientist scientist_model, Project project_model,
			AssignedTo assigned_to_model,Connection conn_with_MySql) {
		this.mainWindowView = main_window;
		this.scientist = scientist_model;
		this.project = project_model;
		this.assignedTo = assigned_to_model;
		this.connWithMySQL = conn_with_MySql;
		
		this.mainWindowView.getDeleteButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Get all the info from the view
		this.infoFromViewToModels();
		// Delete previous table
		// insert new values into table
		this.deleteEntry();

	}

	private void infoFromViewToModels() {
		this.scientist.setDNI(this.mainWindowView.getDeleteScientistDNI());
		
		this.project.setIdProject(this.mainWindowView.getDeleteProjectId());
		
		this.assignedTo.setDNI(this.mainWindowView.getDeleteAssginedToDNI());
		this.assignedTo.setIdProject(this.mainWindowView.getDeleteAssignedToId());
	}
	
	
	private void deleteEntry() {
		if (this.scientist.getDNI() != "") {
			MySQLConnectionHandler.deleteScientist(connWithMySQL, scientist);
		} else {
			System.out.println("Borrado no efectuado");
		}
		
		if (this.project.getIdProject() != "") {
			MySQLConnectionHandler.deleteProject(connWithMySQL, project);
		} else {
			System.out.println("Borrado no efectuado");
		}
		
		if ((this.assignedTo.getDNI() != "") && (this.assignedTo.getProjectId() != "")) {
			MySQLConnectionHandler.deleteAssignedTo(connWithMySQL, assignedTo);
		} else {
			System.out.println("Borrado no efectuado");
		}
	}

}
