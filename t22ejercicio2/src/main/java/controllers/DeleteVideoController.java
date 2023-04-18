/**
 * 
 */
package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Video;
import views.DeleteVideoView;
import views.MainView;

/**
 * @author Marc RG
 *
 */
public class DeleteVideoController implements ActionListener{
	
	private Video video;
	// Vistas
	private MainView vista;
	private DeleteVideoView dvview;
	
	/**
	 * Constructor
	 * 
	 * @param cliente, vista
	 */
	public DeleteVideoController(Video video, MainView vista) {
		this.video = video;
		this.vista = vista;
		this.dvview = new DeleteVideoView();
		initController();
		this.dvview.btnNewButton.addActionListener(this);
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

		dvview.setBackground(new Color(0, 64, 128));
		dvview.setBounds(12, 12, 870, 561);
		dvview.setLayout(null);
		/*
		 * Read Video View Tab
		 */
		vista.tabbedPane.addTab("Elimina Video", null, dvview, "Elimina Video");
		vista.tabbedPane.setEnabledAt(1, true);
		vista.setVisible(true);

	}

	/*
	 * --------------Listeners---------------
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		/*-- Button delete video listener --*/
		try {
			video.setTitle(dvview.tfRead1.getText());
			String titulo = video.getTitle();
			System.out.println(titulo);
			video.deleteVideoByTitle(titulo);
			JOptionPane.showMessageDialog(null, "Video "+titulo+" eliminado satisfactoriamente");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
}
