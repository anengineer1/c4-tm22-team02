/**
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.Database;
import models.Cliente;
import views.CreateClientView;
import views.MainView;

/**
 * @author elena-01
 *
 */
public class CreateClientController implements ActionListener {

	// Model
	private Cliente cliente;
	// Vistas
	private MainView vista;
	private CreateClientView ccview;

	/**
	 * Constructor
	 */
	public CreateClientController(Cliente cliente, MainView vista) {
		this.cliente = cliente;
		this.vista = vista;
		this.ccview = new CreateClientView();
		initController();
		this.ccview.btnCreateClient.addActionListener(this);
		this.ccview.jcFechaAlta.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if ("date".equals(evt.getPropertyName())) {
					System.out.println( evt.getNewValue().toString());
	                System.out.println(evt.getPropertyName()
	                    + ": " + (Date) evt.getNewValue());
	            }
			}
		});
		
	}

	/*
	 * Init the Controller
	 */
	public void initController() {
		// Init the MainView
		initView();

	}

	/*
	 * Init the CreateClientView
	 */
	public void initView() {
		ccview.setBackground(new Color(0, 64, 128));
		ccview.setBounds(12, 12, 870, 500);
		ccview.setLayout(null);

		/*
		 * Create Client View Tab
		 */
		vista.tabbedPane.addTab("Dar de alta Cliente", null, ccview, "Alta de Cliente");
		vista.setVisible(true);
		vista.tabbedPane.setEnabledAt(0, true);
		vista.tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));

	}

	/*
	 * --------------Listeners---------------
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Hola");

		/*-- Button Insert new Client Listener --*/
		try {
			// Catch data that has been introduced by user
			cliente.setNombre(ccview.tfCreate1.getText());
			cliente.setApellido(ccview.tfCreate2.getText());
			cliente.setDireccion(ccview.tfCreate3.getText());
			cliente.setDni(ccview.tfCreate4.getText());
			cliente.setFecha(ccview.jcFechaAlta.getDate());
			
			cliente.insertClientData();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	

}
