package models;

import java.sql.Connection;
import java.sql.ResultSet;

import database.Database;

/**
 * @author Marc RG
 *
 */
public class Video {
	private int id;
	private String title;
	private String director;
	private Cliente cliente;

	private Connection conexion;
	private Database db;

	/**
	 * @param id
	 * @param title
	 * @param director
	 * @param cliente
	 */
	public Video(Database db, Connection conexion) {
		this.db = db;
		this.conexion = conexion;
	}

	/**
	 * 
	 */
	public Video() {
		super();
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void insertVideoData() {

		// String with client attributes
		String newVideo = (null + ",'" + title + "','" + director + "'," + cliente.getId());
		System.out.println(newVideo);

		// Insert data new client in db
		db.insertData("clientes", "video", newVideo, conexion);
	}

}
