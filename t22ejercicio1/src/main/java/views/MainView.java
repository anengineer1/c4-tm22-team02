package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Cursor;

public class MainView extends JFrame {

	private JPanel contentPane;
	// Views to integrate
	private CreateClientView cclient;
	private ReadClientView rclient;
	private UpdateClientView uclient;
	public JTabbedPane tabbedPane;

	/**
	 * Constructor Creates the main window structure for client menu
	 */
	public MainView() {
		setResizable(false);
		setTitle("TEAM02: Ejercicio1 - Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 793);
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// contentPane.setLayout(null);

		/*
		 * 1. TITLE PANEL
		 **/
		JPanel paneltitle = new JPanel();
		paneltitle.getLayout();
		paneltitle.setBounds(0, 10, 899, 138);

		JLabel lbl00 = new JLabel("     GESTION DE CLIENTES");
		lbl00.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl00.setIcon(new ImageIcon(MainView.class.getResource("/resources/assets/icons/client.png")));
		lbl00.setHorizontalAlignment(SwingConstants.CENTER);
		lbl00.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));
		paneltitle.add(lbl00);

		/*
		 * 2. TABBED PANEL
		 */
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane.setBounds(0, 153, 899, 601);
		contentPane.setLayout(null);

		// Add into Main Panel (contentPane): the panelTitle and tabbedPane
		contentPane.add(paneltitle);
		contentPane.add(tabbedPane);
	}
}
