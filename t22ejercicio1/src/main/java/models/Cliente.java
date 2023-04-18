/**
 * 
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

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
	private Date fechaDate;
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
	 * @return the fecha formato Date
	 */
	public Date getFechaDate() {
		return fechaDate;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String mysqlFecha = formatter.format(fecha);
		this.fecha = mysqlFecha;
	}

	public void setFechaDate(Date fechaD) {
 System.out.println("set"+fechaD);
		this.fechaDate = fechaD;
	}

	/*
	 * CREATE: Insert Client in db
	 */
	public void insertClientData() throws SQLException {

		// String with client attributes
		String newClient = (null + ",'" + nombre + "','" + apellido + "','" + direccion + "'," + Integer.parseInt(dni)
				+ ",'" + fecha + "'");
		System.out.println(newClient);

		// Insert data new client in db
		db.insertData("clientes", "cliente", newClient, conexion);
	}

	/*
	 * READ: Select rows by Name
	 */
	public ResultSet readClientDataName(String string) throws SQLException {
		ResultSet rs;
		rs = db.getValuesName("clientes", "cliente", conexion, nombre);
		System.out.println(rs);
		return rs;
	}

	/*
	 * READ: Select rows by Dni
	 */
	public ResultSet readClientDataDni(String dni) throws SQLException {
		ResultSet rs;
		rs = db.getValuesDni("clientes", "cliente", conexion, Integer.parseInt(dni));
		System.out.println(rs);
		return rs;
	}

	/*
	 * UPDATE: Update client
	 *  
	 */

	public void updateClientData() throws SQLException {

		String atributosUpdate = (" nombre='"+nombre + "',apellido='" + apellido + "',direccion='" + direccion + "',dni=" + Integer.parseInt(dni) + ",fecha='"
				+ fechaDate + "'");
		
		System.out.println(atributosUpdate);
		
		db.updateData("clientes", "cliente", atributosUpdate, Integer.parseInt(dni), conexion);
		JOptionPane.showMessageDialog(null, "Usuario Actualizado Correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
	}


	public void deleteClientDataDni(String dni2) throws SQLException  {
		db.deleteDatabaseByDni("clientes", "cliente", "dni", Integer.parseInt(dni2), conexion);
		JOptionPane.showMessageDialog(null, "Usuario Eliminado Correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
