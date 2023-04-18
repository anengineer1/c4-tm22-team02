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

/*
 * Static methods for handling the flux of information to the database
 */
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
		String query = "'" + assigned_to.getDNI() + "'" + ", " + "'" + assigned_to.getProjectId() + "'";
		insertData("TA22_ej3", "ASIGNADO_A", query, conexion);
	}

	public static ResultSet lookUpData(Connection conexion, Scientist scientist, Project project,
			AssignedTo assigned_to) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "SELECT CIENTIFICOS.DNI, CIENTIFICOS.NOMAPELS, PROYECTO.ID, PROYECTO.NOMBRE, PROYECTO.HORAS ";
			Query += "FROM CIENTIFICOS ";
			Query += "INNER JOIN ASIGNADO_A ON CIENTIFICOS.DNI = ASIGNADO_A.DNI ";
			Query += "INNER JOIN PROYECTO ON ASIGNADO_A.ID = PROYECTO.ID ";
			Query += "WHERE CIENTIFICOS.DNI LIKE " + "'" + scientist.getDNI() + "' ";
			Query += "AND CIENTIFICOS.NOMAPELS LIKE " + "'" + scientist.getNomApels() + "' ";
			Query += "AND PROYECTO.ID LIKE " + "'" + project.getIdProject() + "' ";
			Query += "AND PROYECTO.NOMBRE LIKE " + "'" + project.getName() + "' ";
			Query += "AND PROYECTO.HORAS LIKE " + "'" + project.getHours() + "';";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(Query);
			System.out.println("Datos mostrados");
			return rs;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public static ResultSet lookUpScientistData(Connection conexion, Scientist scientist) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "SELECT * ";
			Query += "FROM CIENTIFICOS ";
			Query += "WHERE DNI LIKE " + "'" + scientist.getDNI() + "' ";
			Query += "AND NOMAPELS LIKE " + "'" + scientist.getNomApels() + "';";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(Query);
			System.out.println("Datos mostrados");
			return rs;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public static ResultSet lookUpProjectData(Connection conexion, Project project) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "SELECT * ";
			Query += "FROM PROYECTO ";
			Query += "WHERE Id LIKE " + "'" + project.getIdProject() + "' ";
			Query += "AND Nombre LIKE " + "'" + project.getName() + "' ";
			Query += "AND Horas LIKE " + "'" + project.getHours() + "';";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(Query);
			System.out.println("Datos mostrados");
			return rs;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public static ResultSet lookUpAssignedToData(Connection conexion, AssignedTo assigned_to) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "SELECT * ";
			Query += "FROM ASIGNADO_A ";
			Query += "WHERE DNI LIKE " + "'" + assigned_to.getDNI() + "' ";
			Query += "AND ID LIKE " + "'" + assigned_to.getProjectId() + "';";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(Query);
			System.out.println("Datos mostrados");
			return rs;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public static void deleteScientist(Connection conexion, Scientist scientist) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM CIENTIFICOS " + "WHERE DNI = " + "'" + scientist.getDNI() + "' " + "LIMIT 1;";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos borrados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void deleteProject(Connection conexion, Project project) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM PROYECTO " + "WHERE Id = " + "'" + project.getIdProject() + "' " + "LIMIT 1;";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos borrados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void deleteAssignedTo(Connection conexion, AssignedTo assigned_to) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM ASIGNADO_A " + "WHERE DNI = " + "'" + assigned_to.getDNI() + "' " + "AND Id = "
					+ "'" + assigned_to.getProjectId() + "' " + ";";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos borrados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void updateScientist(Connection conexion, Scientist scientist) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "UPDATE CIENTIFICOS SET ";
			Query += "NomApels = " + "'" + scientist.getNomApels() + "' ";
			Query += "WHERE " + "DNI = " + scientist.getDNI();
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos actualizados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void updateProject(Connection conexion, Project project) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "UPDATE PROYECTO SET ";
			if (!project.getName().isEmpty()) {
				Query += "Nombre = " + "'" + project.getName() + "' ";
			} else if (!project.getName().isEmpty() && !project.getHours().isEmpty()) {
				Query += "Nombre = " + "'" + project.getName() + "', ";
				Query += "Horas = " + project.getHours();
			} else if (project.getHours() != "") {
				Query += "Horas = " + "'" + project.getHours() + "' ";
			}
			Query += "WHERE " + "Id = " + project.getIdProject() + ";";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos borrados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void updateAssignedTo(Connection conexion, AssignedTo assigned_to) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "UPDATE CIENTIFICOS SET ";

			Query += "Id = " + "'" + assigned_to.getProjectId() + "' ";
			Query += "WHERE " + "DNI = " + assigned_to.getDNI() + ";";

			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos borrados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void deleteEntry(Connection conexion, AssignedTo assigned_to) {

		try {
			String db = "TA22_ej3";
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			String Query = "DELETE FROM ASIGNADO_A WHERE DNI LIKE " + "'" + assigned_to.getDNI() + "' " + "AND Id LIKE " + "'"
					+ assigned_to.getProjectId() + "'; " + "DELETE FROM CIENTIFICOS WHERE DNI LIKE " + "'"
					+ assigned_to.getDNI() + "' " + "AND NOT EXISTS (SELECT * FROM ASIGNADO_A WHERE DNI LIKE " + "'"
					+ assigned_to.getDNI() + "'); " + "DELETE FROM PROYECTO WHERE Id LIKE " + "'"
					+ assigned_to.getProjectId() + "' " + "AND NOT EXISTS (SELECT * FROM ASIGNADO_A WHERE Id LIKE " + "'"
					+ assigned_to.getProjectId() + "');";
			System.out.println(Query);
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos borrados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

//	
//	public static void lookUpScientists(Connection conexion, Scientist scientist) {
//		String query = "'" + scientist.getDNI() + "'" + ", " + "'" + scientist.getNomApels() + "'";
//		insertData("TA22_ej3", "CIENTIFICOS", query, conexion);
//	}
//	
//	public static void lookUpProject(Connection conexion, Project project) {
//		String query = project.getIdProject() + ", " + "'" + project.getName() + "'" + ", " + project.getHours();
//		insertData("TA22_ej3", "PROYECTO", query, conexion);
//	}
//	
//	public static void lookUpAssignedTo(Connection conexion, AssignedTo assigned_to) {
//		String query = "'" + assigned_to.getDNI() + "'" + ", " + "'" + assigned_to.getProjectName() + "'";
//		insertData("TA22_ej3", "ASIGNADO_A", query, conexion);
//	}
}
