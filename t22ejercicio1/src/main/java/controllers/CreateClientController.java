/**
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.Database;
import models.Cliente;
import views.CreateClientView;
import views.MainView;

/**
 * @author elena-01
 *
 */
public class CreateClientController implements ActionListener {

	// Model
	private Cliente cliente;
	// Vistas
	private MainView vista;
	private CreateClientView ccview;
	// Database
	private Connection conexion;
	private Database db;

	/**
	 * Constructor
	 */
	public CreateClientController(Cliente cliente, MainView vista) {
		this.cliente = cliente;
		this.vista = vista;
		this.ccview.btnCreateClient.addActionListener(this);
	}

	/*
	 * Init the Cntroller
	 */
	public void initController() {
		System.out.println("Hello");
		// Init the MainView
		initView();
		// Init the conection, create database, table and insert some initial data
		initConnection();
		// Catch data insert in view by user and send to insert in table sql
		// Close connection
		db.closeConnection(conexion);
	}

	/*
	 * Init the MainView
	 */
	public void initView() {
		vista.setAlwaysOnTop(true);
		vista.setTitle("TEAM02: Ejercicio1 - Clientes");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setBounds(100, 100, 914, 793);
		vista.setVisible(true);
	}

	/*
	 * public void initListeners() { -- Button Insert new Client Listener --
	 * .actionPerformed(ActionEvent e() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { clickNewClient(); }
	 * 
	 * }); }
	 */

	/*
	 * Connect to databse
	 */
	public void conectDatabase(String tableName) {
		// --Open Connection--
		conexion = db.openConnection(conexion);
		// --Check if exist and eliminate db
		// db.dropDatabase("Clientes", conexion);
		// --Create db
		db.createDatabase(tableName, conexion);
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
					+ "direccion varchar(250) DEFAULT NULL,\r\n" + "dni int(11) DEFAULT NULL,\r\n"
					+ "fecha date DEFAULT NULL,\r\n" + "PRIMARY KEY(id)";
			// -- Create table clients
			db.createTable("clientes", "cliente", atributosCliente, conexion);
			// -- Data
			String cliente1 = (", 'Ana', 'Lopez', 'Calle Granvia 45', '7777777A', '' ");
			String cliente2 = (", 'Juan', 'Martinez', 'Calle del Pez 45', '7775555A', '' ");
			String cliente3 = (", 'Maria', 'Perez', 'Calle del Manzano 45', '3335555A', '' ");

			// --1.CREATE DATA:insert data in table clients
			db.insertData("clientes", "cliente", cliente1, conexion);
			db.insertData("clientes", "cliente", cliente2, conexion);
			db.insertData("clientes", "cliente", cliente3, conexion);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/*
	 * Init the Listeners
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Hola");

		/*-- Button Insert new Client Listener --*/
		try {
			//TODO:????????
			initController();
			// Catch data that has been introduced by user
			cliente.setNombre(ccview.tfCreate1.getText());
			cliente.setApellido(ccview.tfCreate2.getText());
			cliente.setDireccion(ccview.tfCreate3.getText());
			cliente.setDni(ccview.tfCreate4.getText());
			cliente.setFecha(ccview.jcFechaAlta.getTodayButtonText());

			// String with client attributes
			String newClient = (null + "," + cliente.getNombre() + "," + cliente.getApellido() + ","
					+ Integer.parseInt(cliente.getDni()) + "," + cliente.getFecha());

			// Insert data new client in db
			db.insertData("clientes", "cliente", newClient, conexion);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
