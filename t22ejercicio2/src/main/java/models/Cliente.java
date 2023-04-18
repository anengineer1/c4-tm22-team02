/**
 * 
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Database;

/**
 * @author elena-01
 *
 */
public class Cliente {

	/* ----- Atributos ---- */
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	private String fecha;
	// Database
	private Connection conexion;
	private Database db;

	/**
	 * 
	 */
	public Cliente(Database db, Connection conexion) {
		// TODO Auto-generated constructor stub
		this.db = db;
		this.conexion = conexion;
	}

	public Cliente() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void insertClientData() {

		// String with client attributes
		String newClient = (null + "," + nombre + "," + apellido + "," + Integer.parseInt(dni) + "," + fecha);
		System.out.println(newClient);

		// Insert data new client in db
		db.insertData("clientes", "cliente", newClient, conexion);
	}

	public ResultSet readClientDataDni(String dni) {
		ResultSet rs;
		rs = db.getValuesDni("clientes", "cliente", conexion, Integer.parseInt(dni));
		System.out.println(rs);
		return rs;
	}

	public ResultSet readClientDataName(String string) {
		ResultSet rs;
		rs = db.getValuesName("clientes", "cliente", conexion, nombre);
		System.out.println(rs);
		return rs;
	}

	public int readClientIdByDni(String dni) throws SQLException {
		Database dbtest = new Database();
		conexion = dbtest.openConnection(conexion);
		int id = db.getClientIdByDni("clientes", "cliente", conexion, Integer.parseInt(dni));
		conexion.close();
		return id;
	}

}
