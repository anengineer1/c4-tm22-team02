package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Component;
import java.awt.Cursor;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	// Views to integrate
	private CreateClientView cclient;
	private ReadClientView rclient;
	private UpdateClientView uclient;
	private DeleteClientView dclient;


	/**
	 * Constructor Creates the main window structure for client menu 
	 */
	public MainView (){
		setAlwaysOnTop(true);
		setTitle("TEAM02: Ejercicio1 - Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 756);
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		//contentPane.setLayout(null);

		/*
		 * 1. TITLE PANEL
		 **/
		JPanel paneltitle = new JPanel();
		FlowLayout fl_paneltitle = (FlowLayout) paneltitle.getLayout();
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
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane.setBounds(0, 153, 899, 552);
		contentPane.setLayout(null);
		
		
		
		//Add into Main Panel (contentPane): the panelTitle and tabbedPane 
		contentPane.add(paneltitle);
		contentPane.add(tabbedPane);
		
		/*
		 * Create Client View
		 */
		JPanel panel_crear_cliente = new JPanel();
		/*
		 * panel_crear_cliente.setForeground(new Color(255, 255, 255));
		 * panel_crear_cliente.setFont(new Font("Franklin Gothic Demi", Font.PLAIN,14));
		 * panel_crear_cliente.setToolTipText("Dar de alta cliente en base de datos");
		 * panel_crear_cliente.setName(""); panel_crear_cliente.setBackground(new
		 * Color(0, 64, 128));
		 */

		tabbedPane.addTab("Dar de alta Cliente", null, panel_crear_cliente, "Alta de Cliente");
		panel_crear_cliente.setLayout(null);
		
		//Create view for CreateClient
		cclient= new CreateClientView(panel_crear_cliente);
		cclient.setBackground(new Color(0, 64, 128));
		cclient.setBounds(12, 12, 870, 500);
		panel_crear_cliente.add(cclient);
		cclient.setLayout(new GridLayout(1, 0, 0, 0));
		this.setVisible(true);
		
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		//panel_crear_cliente.setLayout(null);
		

		/*
		 * Read Client View
		 */
		JPanel panel_consultar_cliente = new JPanel();
		panel_consultar_cliente.setToolTipText("Consulta de cliente en base de datos");
		panel_consultar_cliente.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Consulta Cliente", null, panel_consultar_cliente, "Consulta Cliente");
		panel_consultar_cliente.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 73, 896, 275);
		panel_consultar_cliente.add(scrollPane);
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(0, 0, 677, 243);
		panel_consultar_cliente.add(table);
		tabbedPane.setEnabledAt(1, true);

		/*
		 * UPDATE CLIENT VIEW
		 */
		JPanel panel_actualizar_cliente = new JPanel();
		panel_actualizar_cliente.setToolTipText("Actualizar datos de cliente en base de datos");
		panel_actualizar_cliente.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Actualizar Cliente", null, panel_actualizar_cliente, null);

		/*
		 * DELETE CLIENT VIEW
		 */
		JPanel panel_borrar_cliente = new JPanel();
		panel_borrar_cliente.setToolTipText("Borrar cliente en base de datos");
		panel_borrar_cliente.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Borrar Cliente", null, panel_borrar_cliente, null);

		
		//Create views
		//cclient= new CreateClientView(panel_crear_cliente);
		//rclient= new ReadClientView();
		//uclient= new UpdateClientView();
		//dclient= new DeleteClientView();

	}
}
