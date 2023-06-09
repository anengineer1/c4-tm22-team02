/**
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.Database;
import models.Cliente;
import views.CreateClientView;
import views.DeleteClientView;
import views.MainView;
import views.ReadClientView;
import views.UpdateClientView;

/**
 * @author elena-01
 *
 */
public class MainController {

	// Model
	public Cliente client;
	// Views + Controllers Atributes
	private MainView mview;
	public CreateClientView ccview;
	private CreateClientController ccontrol;
	private ReadClientView rcview;
	private ReadClientController rcontrol;
	private UpdateClientView ucview;
	private UpdateClientController ucontrol;
	private DeleteClientView dcview;
	private DeleteClientController dcontrol;
	// Conexion
	private Database db;
	private Connection conexion;

	/**
	 * 
	 */
	public MainController(MainView mview) {

		// Initialize database
		db = new Database();
		// Init the conection, create database, table and insert some initial data
		initConnection();
		// Model
		client = new Cliente(db, conexion);
		// Create view for CreateClient
		ccontrol = new CreateClientController(client, mview);
		ccontrol.initController();
		// Create view for ReadClient
		rcontrol = new ReadClientController(client, mview);
		rcontrol.initController();

		// Create view for UpdateClient
		ucontrol = new UpdateClientController(client, mview);
		ucontrol.initController();
		
		// Create view for DeleteClient
		dcontrol = new DeleteClientController(client, mview);
		dcontrol.initController();

		mview.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// Close connection
				db.closeConnection(conexion);
			}
		});

	}

	/*
	 * Connect to databse
	 */
	public void conectDatabase(String dbName) {
		// --Open Connection--
		conexion = db.openConnection(conexion);
		// --Check if exist and eliminate db
		// db.dropDatabase("Clientes", conexion);
		// --Create db
		db.createDatabase(dbName, conexion);
	}

	/*
	 * Init the conection, create database, table and insert some initial data
	 */
	public void initConnection() {
		try {
			// -- Connect and create db
			conectDatabase("clientes");
			// --String that contains table's attibutes
			String atributosCliente = "id int(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "nombre varchar(250) DEFAULT NULL,\r\n" + "apellido varchar(250) DEFAULT NULL,\r\n"
					+ "direccion varchar(250) DEFAULT NULL,\r\n" + "dni int(11) DEFAULT NULL UNIQUE,\r\n"
					+ "fecha date DEFAULT NULL,\r\n" + "PRIMARY KEY(id)";
			// -- Create table clients
			db.createTable("clientes", "cliente", atributosCliente, conexion);
			// -- Data
			String cliente1 = ("null,'Ana', 'Lopez', 'Calle Granvia 45', '7777777', '2023-04-03' ");
			String cliente2 = ("null,'Juan', 'Martinez', 'Calle del Pez 45', '7775555', '2023-04-03' ");
			String cliente3 = ("null,'Maria', 'Perez', 'Calle del Manzano 45', '3335555', '2023-04-16' ");

			// --1.CREATE DATA:insert data in table clients
			db.insertData("clientes", "cliente", cliente1, conexion);
			db.insertData("clientes", "cliente", cliente2, conexion);
			db.insertData("clientes", "cliente", cliente3, conexion);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
