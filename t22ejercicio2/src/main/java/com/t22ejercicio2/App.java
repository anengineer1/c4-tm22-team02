package com.t22ejercicio2;

import java.awt.EventQueue;

import controllers.MainController;
import views.CreateVideoView;
import views.MainView;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
					MainController controller = new MainController(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
