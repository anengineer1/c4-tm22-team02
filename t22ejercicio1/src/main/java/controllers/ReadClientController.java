/**
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Cliente;
import views.MainView;
import views.ReadClientView;

/**
 * @author elena-01
 *
 */
public class ReadClientController implements ActionListener {

	// Model
	private Cliente cliente;
	// Vistas
	private MainView vista;
	private ReadClientView rcview;

	/**
	 * Constructor
	 * 
	 * @param cliente, vista
	 */
	public ReadClientController(Cliente cliente, MainView vista) {
		this.cliente = cliente;
		this.vista = vista;
		this.rcview = new ReadClientView();
		initController();
		this.rcview.btnNewButton.addActionListener(this);
	}

	/*
	 * Inite the controller
	 */
	public void initController() {
		// Init the ReadClientView
		initView();
	}

	/*
	 * Init the ReadClientView
	 */
	private void initView() {

		rcview.setBackground(new Color(0, 64, 128));
		rcview.setBounds(12, 12, 870, 561);
		rcview.setLayout(null);
		/*
		 * Read Client View Tab
		 */
		vista.tabbedPane.addTab("Consulta Cliente", null, rcview, "Consulta Cliente");
		vista.tabbedPane.setEnabledAt(1, true);
		vista.setVisible(true);

	}

	/*
	 * --------------Listeners---------------
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		/*-- Button Insert new Client Listener --*/
		try {
			System.out.println("Hola");
			//Check if the filter is by name or DNI
			if(!rcview.tfRead1.getText().isEmpty() && rcview.tfRead2.getText().isEmpty()) {
				System.out.println("Hola nombre");
				cliente.setNombre(rcview.tfRead1.getText());
				cliente.readClientDataName(cliente.getNombre());
				System.out.println();
			}else if(rcview.tfRead1.getText().isEmpty()&& !rcview.tfRead2.getText().isEmpty()) {
				System.out.println("Hola dni");
				cliente.setDni(rcview.tfRead2.getText());
				cliente.readClientDataDni(cliente.getDni());
			}else {
				System.out.println("Nada");
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
