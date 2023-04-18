/**
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import models.Cliente;
import views.MainView;
import views.UpdateClientView;

/**
 * @author elena-01
 *
 */
public class UpdateClientController implements ActionListener {

	// Model
	private Cliente cliente;
	// Vistas
	private MainView vista;
	private UpdateClientView ucview;
	public ResultSet rs1;
	public ResultSet rs2;
	public Date date;

	/**
	 * Constructor
	 * 
	 * @param cliente, vista
	 */
	public UpdateClientController(Cliente cliente, MainView vista) {
		this.cliente = cliente;
		this.vista = vista;
		this.ucview = new UpdateClientView();
		initController();
		// search client
		this.ucview.btnNewButton2.addActionListener(this);
		// update client
		this.ucview.btnNewButton1.addActionListener(this);

	}

	public void initController() {
		initView();

	}

	private void initView() {
		ucview.setBackground(new Color(0, 64, 128));
		ucview.setBounds(12, 12, 870, 500);
		ucview.setLayout(null);

		/*
		 * Update Client View Tab
		 */
		vista.tabbedPane.addTab("Actualizar Cliente", null, ucview, "Actualiza datos cliente");
		vista.tabbedPane.setEnabledAt(2, true);
		vista.tabbedPane.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If user selects the button to search client
		if (e.getSource() == ucview.btnNewButton2) {

			/*-- Button Update Client Listener --*/
			try {

				if (!ucview.tfUpdate4.getText().isEmpty()) {
					cliente.setDni(ucview.tfUpdate4.getText());
					// get info from db name

					rs1 = cliente.readClientDataDni(cliente.getDni());

					ResultSetMetaData rsmd = rs1.getMetaData();
					int columnsNumber = rsmd.getColumnCount()+1;
					while (rs1.next()) {

						// Set data from dni search
						ucview.tfUpdate1.setText(rs1.getString("nombre"));
						ucview.tfUpdate2.setText(rs1.getString("apellido"));
						ucview.tfUpdate3.setText(rs1.getString("direccion"));
						date = (rs1.getDate("fecha"));
					}
					System.out.println(date);

					
				} else {
					JOptionPane.showMessageDialog(null, "DNI no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			// If user selects the button to update client
		} else if (e.getSource() == ucview.btnNewButton1) {
			/*-- Button Insert new Client Listener --*/
			try {
				// Catch data that has been introduced by user
				cliente.setNombre(ucview.tfUpdate1.getText());
				cliente.setApellido(ucview.tfUpdate2.getText());
				cliente.setDireccion(ucview.tfUpdate3.getText());
				cliente.setDni(ucview.tfUpdate4.getText());
				cliente.setFechaDate(date);
				//Method of Client model to update
				cliente.updateClientData();
				
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		} else {

		}
	}

}
