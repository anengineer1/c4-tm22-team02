/**
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Cliente;
import models.Video;
import views.CreateVideoView;
import views.MainView;
import views.UpdateVideoView;

/**
 * @author Marc RG
 *
 */
public class UpdateVideoController implements ActionListener {
	// Model
	private Video video;
	private Cliente cliente;

	// Vistas
	private MainView vista;
	private UpdateVideoView uvview;

	public UpdateVideoController(Cliente cliente, Video video, MainView vista) {
		this.cliente = cliente;
		this.video = video;
		this.vista = vista;
		this.uvview = new UpdateVideoView();
		initController();
		this.uvview.btnModVideo.addActionListener(this);
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
		uvview.setBackground(new Color(0, 64, 128));
		uvview.setBounds(12, 12, 870, 500);
		uvview.setLayout(null);

		/*
		 * Create Client View Tab
		 */
		vista.tabbedPane.addTab("Modificar video", null, uvview, "Modificar video");
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
		video.setTitle(uvview.tfCreate1.getText());

		String dniViejo = uvview.tfCreate2.getText();
		String dniNuevo = uvview.tfCreate3.getText();

		/*
		 * ResultSet rs = cliente.readClientIdByDni(dniTextField); int id =
		 * rs.getInt("id");
		 */
		int idClienteAntiguo = 0;
		int idClienteNuevo = 0;
		try {
			System.out.println("TRY " + cliente);
			idClienteAntiguo = cliente.readClientIdByDni(dniViejo);
			System.out.println(idClienteAntiguo);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}

		try {
			System.out.println("TRY " + cliente);
			idClienteNuevo = cliente.readClientIdByDni(dniNuevo);
			System.out.println(idClienteNuevo);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}
		
		video.updateVideoClient(idClienteAntiguo, idClienteNuevo);
	}
}
