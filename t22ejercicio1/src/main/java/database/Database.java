package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
//-----------------------------------------------------------------
	public Connection openConnection(Connection conexion) {
		//Connection conexion = null;
		conexion = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.230:3306", "remote", "F3d0r@...");
			System.out.println("Conectado a la base de datos");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error to connect");
			e.printStackTrace();
		}

		return conexion;
	}

	//-----------------------------------------------------------------
	public void createDatabase(String nom, Connection conexion) {

		try {
			String Query = "CREATE DATABASE " + nom;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			// closeConnection(conexion);
			openConnection(conexion);
			// openConnection("root", "", nom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error abriendo la conexion " + e);
		}
	}

	//-----------------------------------------------------------------
	public void closeConnection(Connection conexion) {
		// TODO Auto-generated method stub
		try {
			conexion.close();
			System.out.println("Cerrada la conexion");
		} catch (SQLException e) {
			System.out.println("Error cerrando la conexion: "+ e);
		}
	}

	//-----------------------------------------------------------------
	public void createTable(String db, String table, String atributos, Connection conexion) {
		try {
			// USE database
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			// CREATE TABLE
			Statement st = conexion.createStatement();
			st.executeUpdate("CREATE TABLE " + table + "(" + atributos + ");");
			System.out.println("Table creada: "+table);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando la table: "+ e);
		}
	}

	//-----------------------------------------------------------------
	public void insertData(String db, String table, String atributos, Connection conexion) {
		try {
			// USE database
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			// CREATE TABLE
			Statement st = conexion.createStatement();
			st.executeUpdate("INSERT INTO " + table + " VALUE(" + atributos + ");");
			System.out.println("data insertada: "+ atributos);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error insertando data: "+e);
		}
	}

	//-----------------------------------------------------------------
	public java.sql.ResultSet getValues(String db, String table, Connection conexion) {
		java.sql.ResultSet resultSet = null;
		try {
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			String querySelect = "SELECT * FROM " + table + ";";
			Statement stsel = conexion.createStatement();

			resultSet = stsel.executeQuery(querySelect);

		} catch (SQLException e) {
			System.out.println("Values no coleccionadas correctamente:" +e);
		}
		return resultSet;
	}

	//-----------------------------------------------------------------
	public java.sql.ResultSet getValuesName(String db, String table, Connection conexion, String Name) {
		java.sql.ResultSet resultSet = null;
		try {
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			String querySelect = "SELECT * FROM " + table + " WHERE nombre  = '" + Name+"';";
			Statement stsel = conexion.createStatement();

			resultSet = stsel.executeQuery(querySelect);

		} catch (SQLException e) {
			System.out.println("Values no coleccionadas correctamente:" +e);
		}
		return resultSet;
	}
	
	//-----------------------------------------------------------------
	public java.sql.ResultSet getValuesDni(String db, String table, Connection conexion, int dni) {
		java.sql.ResultSet resultSet = null;
		try {
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			String querySelect = "SELECT * FROM " + table + " WHERE dni=" + dni+";";
			Statement stsel = conexion.createStatement();

			resultSet = stsel.executeQuery(querySelect);

		} catch (SQLException e) {
			System.out.println("Values no coleccionadas correctamente:" +e);
		}
		return resultSet;
	}
	
	
	  //------------------------------UPDATE---------------------------------
	  public void updateData(String db, String table, String atributos, int dni, Connection
	  conexion) { try { // USE database //String queryDB = "USE " + db + ";";
	  String queryBD = ("UPDATE " + db+"."+table+ " SET" + atributos + " where  dni="+dni+";");
	  Statement  stdb = conexion.prepareStatement(queryBD);
	  stdb.executeUpdate(queryBD);
	  
	  } catch (SQLException e) { // TODO Auto-generated catch block
	  System.out.println("Error insertando data: "+e); } }
	 
	
	public void deleteDatabase(String db, String table, String ID,String IDValor, Connection conexion) {
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