/**
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Cliente;
import views.DeleteClientView;
import views.MainView;
import views.ReadClientView;

/**
 * @author elena-01
 *
 */
public class DeleteClientController implements ActionListener{

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
		this.dcview.btnNewButton.addActionListener(this);

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

	
	@Override
	public void actionPerformed(ActionEvent e) {

		/*-- Button Delete Client Listener --*/
		try {
			// Check if the dni is not empty
			if (!dcview.tfDelete1.getText().isEmpty()) {
				cliente.setDni(dcview.tfDelete1.getText());
				// get info from db name
				cliente.deleteClientDataDni(cliente.getDni());
				System.out.println();
			} else {

				JOptionPane.showMessageDialog(null, "No hay usuario que eliminar", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
