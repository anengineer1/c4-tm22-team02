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
 * Controller for reading projects
 */
public class LookUpControllerProject implements ActionListener {

	private MainWindowView mainWindowView;
	private Project project;
	private Connection connWithMySQL;

	public LookUpControllerProject(MainWindowView main_window, Project project_model, Connection conn_with_MySql) {
		this.mainWindowView = main_window;
		this.project = project_model;
		this.connWithMySQL = conn_with_MySql;

		this.mainWindowView.getLookUpProjectButton().addActionListener(this);
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

		this.project.setIdProject(this.mainWindowView.getLookUpProjectId());
		this.project.setName(this.mainWindowView.getLookUpProjectName());
		this.project.setHours(this.mainWindowView.getLookUpProjectHours());
		
	}

	/*
	 * Get the info from db and print it on the JTable
	 */
	private void lookIntoDb() {

		ResultSet rs = MySQLConnectionHandler.lookUpProjectData(this.connWithMySQL, this.project);
		try {
			while (rs.next()) {
				String id = rs.getString("Id");
				String nombre = rs.getString("Nombre");
				int horas = rs.getInt("Horas");
				this.mainWindowView.setProjectRow(id, nombre, Integer.toString(horas));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void clearRows() {
		this.mainWindowView.clearRows();
	}

}
