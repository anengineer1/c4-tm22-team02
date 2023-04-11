package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import models.AssignedTo;
import models.Project;
import models.Scientist;
import views.InsertRelationScientistProject;


public class MySQLConnectionHandler {

	public static Connection initConnection(String ip, String puerto, String usuario, String contrasena) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String prefix = "jdbc:mysql://";
			String sufix = "?useTimezone=true&serverTimezone=UTC";
			String connection_parameter = prefix + ip + ":" + puerto + sufix;
			System.out.println(connection_parameter);
			Connection conexion = DriverManager.getConnection(connection_parameter, usuario, contrasena);
			System.out.println("Server connected");
			return conexion;
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public static Connection closeConnection(Connection conexion) {
		try {
			conexion.close();
			System.out.println("Ha finalizado la conexión con el servidor");
			return conexion;
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar base de datos");
			System.out.println(e.getMessage());
			return conexion;
		}
	}
	
	public static void insertData(String db, String table_name, String query, Connection conexion) {

		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "Insert Into " + table_name + " VALUES " + "(" + query + ");";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos almacenados correctos");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void insertScientists(Connection conexion, Scientist scientist) {
		String query = "'" + scientist.getDNI() + "'" + ", " + "'" + scientist.getNomApels() + "'";
		insertData("TA22_ej3", "CIENTIFICOS", query, conexion);
	}
	
	public static void insertProject(Connection conexion, Project project) {
		String query = project.getIdProject() + ", " + "'" + project.getName() + "'" + ", " + project.getHours();
		insertData("TA22_ej3", "PROYECTO", query, conexion);
	}
	
	public static void insertAssignedTo(Connection conexion, AssignedTo assigned_to) {
		String query = "'" + assigned_to.getDNI() + "'" + ", " + "'" + assigned_to.getProjectName() + "'";
		insertData("TA22_ej3", "ASIGNADO_A", query, conexion);
	}
}