package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.ResultSet;

import database.Database;
import models.Cliente;
import models.Video;
import views.CreateClientView;
import views.CreateVideoView;
import views.MainView;

/**
 * @author Marc RG
 *
 */
public class CreateVideoController implements ActionListener {

	// Model
	private Video video;
	private Cliente cliente = new Cliente();
	
	// Vistas
	private MainView vista;
	private CreateVideoView cvview;
	
	public CreateVideoController(Video video, MainView vista) {
		this.video = video;
		this.vista = vista;
		this.cvview = new CreateVideoView();
		initController();
		this.cvview.btnAddVideo.addActionListener(this);
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
		cvview.setBackground(new Color(0, 64, 128));
		cvview.setBounds(12, 12, 870, 500);
		cvview.setLayout(null);

		/*
		 * Create Client View Tab
		 */
		vista.tabbedPane.addTab("Añadir nuevo video", null, cvview, "Añadir video");
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
		
			// Catch data that has been introduced by user
			video.setTitle(cvview.tfCreate1.getText());
			video.setDirector(cvview.tfCreate2.getText());
			String dniTextField = cvview.tfCreate3.getText();
			System.out.println(dniTextField);
			/*
			ResultSet rs = cliente.readClientIdByDni(dniTextField);
			int id = rs.getInt("id");
			*/
			try {
				int id = cliente.readClientIdByDni(dniTextField);
				System.out.println(id);
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
			
			//int id = cliente.readClientIdByDni(dniTextField);
			
			//System.out.println(id);
			//video.setId(id);
			//video.insertVideoData();
			//cliente.setDni(dni);
			//video.setCliente(cliente);
			
			//cliente.insertClientData();

		
	}
}
