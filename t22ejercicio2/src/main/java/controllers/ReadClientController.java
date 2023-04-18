/**
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	private ResultSet rs;
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
			// Check if the filter is by name or DNI
			if (!rcview.tfRead1.getText().isEmpty() && rcview.tfRead2.getText().isEmpty()) {
				cliente.setNombre(rcview.tfRead1.getText());
				// get info from db name
				rs = cliente.readClientDataName(cliente.getNombre());
				System.out.println();
			} else if (rcview.tfRead1.getText().isEmpty() && !rcview.tfRead2.getText().isEmpty()) {
				System.out.println("Hola dni");
				cliente.setDni(rcview.tfRead2.getText());
				// get info from db dni
				rs = cliente.readClientDataDni(cliente.getDni());

			} else {
				System.out.println("Nada");
			}

			// Show results in table
			
			rcview.tableClients.setModel (buildTableModel(rs));
			//rcview.add(new JScrollPane(rcview.tableClients));
			
			//Add scroll to table 
			/*
			 * JScrollPane js=new JScrollPane(rcview.tableClients); js.setVisible(true);
			 * rcview.add(js);
			 */

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	/*
	 * Build Table Model to Show with DefaultTableModel
	 */
	public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		
		// header columns
		Vector<String> columnNames = new Vector<String>();

		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			System.out.println(metaData.getColumnName(column));
			columnNames.add(metaData.getColumnName(column));
			System.out.println(columnNames);
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}
		
		return new DefaultTableModel(data, columnNames);

	}

}