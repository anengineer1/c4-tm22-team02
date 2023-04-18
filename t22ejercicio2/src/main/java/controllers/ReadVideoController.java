package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import database.Database;
import models.Cliente;
import models.Video;
import views.MainView;
import views.ReadClientView;
import views.ReadVideoView;

public class ReadVideoController implements ActionListener {
	
	// Model
		private Cliente cliente;
		private Video video;
		// Vistas
		private MainView vista;
		private ReadVideoView rvview;
		private ResultSet rs;
		/**
		 * Constructor
		 * 
		 * @param cliente, vista
		 */
		public ReadVideoController(Cliente cliente, Video video, MainView vista) {
			this.cliente = cliente;
			this.video = video;
			this.vista = vista;
			this.rvview = new ReadVideoView();
			initController();
			this.rvview.btnNewButton.addActionListener(this);
		}

		/*
		 * Inite the controller
		 */
		public void initController() {
			// Init the ReadClientView
			initView();
		}

		/*
		 * Init the ReadVideoView
		 */
		private void initView() {

			rvview.setBackground(new Color(0, 64, 128));
			rvview.setBounds(12, 12, 870, 561);
			rvview.setLayout(null);
			/*
			 * Read Video View Tab
			 */
			vista.tabbedPane.addTab("Consulta Video", null, rvview, "Consulta Video");
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
				if (!rvview.tfRead1.getText().isEmpty() && rvview.tfRead2.getText().isEmpty()) {
					video.setTitle(rvview.tfRead1.getText());
					// get info from db name
					rs = video.readVideoByTitle(video.getTitle());
					System.out.println();
				} else if (rvview.tfRead1.getText().isEmpty() && !rvview.tfRead2.getText().isEmpty()) {
					video.setDirector(rvview.tfRead2.getText());
					// get info from db dni
					rs = video.readVideoByDirector(video.getDirector());

				} else {
					System.out.println("Nada");
				}

				// Show results in table
				
				rvview.tableVideos.setModel(buildTableModel(rs));
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
