/**
 * 
 */
package controllers;

import java.awt.Color;

import models.Cliente;
import views.DeleteClientView;
import views.MainView;
import views.ReadClientView;

/**
 * @author elena-01
 *
 */
public class DeleteClientController {

	// Model
	private Cliente cliente;
	// Vistas
	private MainView vista;
	private DeleteClientView dcview;

	/**
	 * Constructor
	 * 
	 * @param cliente, vista
	 */
	public DeleteClientController(Cliente cliente, MainView vista) {
		this.cliente = cliente;
		this.vista = vista;
		this.dcview = new DeleteClientView();
		initController();
		// this.dcview.btnNewButton.addActionListener(this);

	}

	public void initController() {
		// Init the DeleteClientView
		initView();

	}

	private void initView() {
		dcview.setBackground(new Color(0, 64, 128));
		dcview.setBounds(12, 12, 870, 561);
		dcview.setLayout(null);

		vista.tabbedPane.addTab("Borrar Cliente", null, dcview, "Eliminacion Cliente");
		vista.tabbedPane.setEnabledAt(3, true);
		vista.setVisible(true);
	}

}
