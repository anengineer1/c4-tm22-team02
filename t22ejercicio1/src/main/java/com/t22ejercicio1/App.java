package com.t22ejercicio1;

import java.awt.EventQueue;

import controllers.MainController;
import views.MainView;

/**
 * Hello world!
 *
 */
public class App 
{
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
					MainController mcontrol = new MainController(frame);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
