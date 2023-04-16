package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	/**
	 * Funcion para establecer conexion con la BD
	 * 
	 * @return objeto Connection
	 */
	public Connection conectarDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.68.109:3306", "root", "R@@t1234");
			return conexion;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Conexion fallida");
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Funcion para cerrar la conexion a la BD
	 */
	public void closeConnection(Connection conexion) {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexion");
			System.out.println(e);
		}
	}

	public void createDatabase(String nombre, Connection conexion) {

		try {
			String Query = "CREATE DATABASE " + nombre;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			// closeConnection(conexion);
			conectarDB();
			// openConnection("root", "", nom);
		} catch (SQLException e) {
			System.out.println("Error abriendo la conexion " + e);
		}
	}

	public void createTable(String db, String table, String atributos, Connection conexion) {
		try {
			// USE database
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			// CREATE TABLE
			Statement st = conexion.createStatement();
			st.executeUpdate("CREATE TABLE " + table + "(" + atributos + ");");
			System.out.println("Table creada: " + table);

		} catch (SQLException e) {
			System.out.println("Error creando la table: " + e);
		}
	}

	public void insertData(String db, String table, String atributos, Connection conexion) {

		try {
			// USE database
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			// CREATE TABLE
			Statement st = conexion.createStatement();
			st.executeUpdate("INSERT INTO " + table + " VALUE(" + atributos + ");");
			System.out.println("data insertada: " + atributos);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error insertando data: " + e);
		}

	}

	public ResultSet getValues(String db, String table, Connection conexion) {
		ResultSet resultSet = null;

		try {
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			String querySelect = "SELECT * FROM " + table + ";";
			Statement stsel = conexion.createStatement();

			resultSet = stsel.executeQuery(querySelect);

		} catch (SQLException e) {
			System.out.println("Values no coleccionadas correctamente:" + e);
		}
		return resultSet;
	}

	public void deleteDatabase(String db, String table, String ID, String IDValor, Connection conexion) {

		try {
			String query = "DELETE FROM " + table + " WHERE " + ID + " = " + IDValor;
			Statement delTable = conexion.createStatement();
			delTable.executeUpdate(query);
			System.out.println(2);

		} catch (SQLException e) {
			System.out.println("Values not deleted correctly");
		}

	}

	public void dropDatabase(String db, Connection conexion) {
		try {
			String queryDB = "DROP DATABASE IF EXISTS " + db;
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

		} catch (SQLException ex) {
			System.out.println("Drop incomplete");
		}

	}
}
