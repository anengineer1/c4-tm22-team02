package models;

public class Video {
	private int id;
	private String title;
	private String director;
	private Cliente cliente;

	/**
	 * @param id
	 * @param title
	 * @param director
	 * @param cliente
	 */
	public Video(int id, String title, String director, Cliente cliente) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.cliente = cliente;
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

}
