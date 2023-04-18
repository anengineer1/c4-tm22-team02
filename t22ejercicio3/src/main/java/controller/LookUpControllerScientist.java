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
 * Controller for reading scientists
 */
public class LookUpControllerScientist implements ActionListener {

	private MainWindowView mainWindowView;
	private Scientist scientist;
	private Connection connWithMySQL;

	public LookUpControllerScientist(MainWindowView main_window, Scientist scientist_model,
			Connection conn_with_MySql) {
		this.mainWindowView = main_window;
		this.scientist = scientist_model;
		this.connWithMySQL = conn_with_MySql;

		this.mainWindowView.getLookUpScientistButton().addActionListener(this);
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
	}

	/*
	 * Get the info from db and print it on the JTable
	 */
	private void lookIntoDb() {

		ResultSet rs = MySQLConnectionHandler.lookUpScientistData(this.connWithMySQL, this.scientist);
		try {
			while (rs.next()) {
				String dni = rs.getString("DNI");
				String nomApels = rs.getString("NomApels");
				this.mainWindowView.setScientistRow(dni, nomApels);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void clearRows() {
		this.mainWindowView.clearRows();
	}

}
