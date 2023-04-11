package com.t22ejercicio1;

import java.awt.EventQueue;

import views.Mainview;

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
					Mainview frame = new Mainview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
