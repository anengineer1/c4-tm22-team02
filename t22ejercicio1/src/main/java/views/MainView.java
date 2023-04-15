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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTable tableClients;
	// Views to integrate
	private CreateClientView cclient;
	private ReadClientView rclient;
	private UpdateClientView uclient;
	private DeleteClientView dclient;
	private JTextField tfRead1;
	private JTextField tfRead2;


	/**
	 * Constructor Creates the main window structure for client menu 
	 */
	public MainView (){
		setAlwaysOnTop(true);
		setTitle("TEAM02: Ejercicio1 - Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 793);
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
		tabbedPane.setBounds(0, 153, 899, 601);
		contentPane.setLayout(null);
		
		
		
		//Add into Main Panel (contentPane): the panelTitle and tabbedPane 
		contentPane.add(paneltitle);
		contentPane.add(tabbedPane);
		
		/*
		 * Create Client View
		 */
		JPanel panel_crear_cliente = new JPanel();
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

		/*
		 * UPDATE CLIENT VIEW
		 */
		JPanel panel_consultar_cliente = new JPanel();
		panel_consultar_cliente.setToolTipText("Consulta de cliente en base de datos");
		panel_consultar_cliente.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Consulta Cliente", null, panel_consultar_cliente, "Consulta Cliente");
		tabbedPane.setEnabledAt(1, true);
		GridBagLayout gbl_panel_consultar_cliente = new GridBagLayout();
		gbl_panel_consultar_cliente.columnWidths = new int[]{47, 44, 236, 200, 140, 97, 46, 0};
		gbl_panel_consultar_cliente.rowHeights = new int[]{3, 20, 105, 26, 0, 29, 27, 0, 0, 187, 0};
		gbl_panel_consultar_cliente.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_consultar_cliente.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_consultar_cliente.setLayout(gbl_panel_consultar_cliente);
		
		//Label Tab Read Client
		JLabel lbl_consulta_cliente = new JLabel("Consulta cliente");
		lbl_consulta_cliente.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		lbl_consulta_cliente.setIcon(new ImageIcon(MainView.class.getResource("/resources/assets/icons/read-client.png")));
		lbl_consulta_cliente.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_consulta_cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_consulta_cliente.setToolTipText("Consulta cliente");
		lbl_consulta_cliente.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lbl_consulta_cliente.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lbl_consulta_cliente = new GridBagConstraints();
		gbc_lbl_consulta_cliente.gridwidth = 2;
		gbc_lbl_consulta_cliente.fill = GridBagConstraints.BOTH;
		gbc_lbl_consulta_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_consulta_cliente.gridx = 2;
		gbc_lbl_consulta_cliente.gridy = 2;
		panel_consultar_cliente.add(lbl_consulta_cliente, gbc_lbl_consulta_cliente);
		
		JLabel lblRead1 = new JLabel("Filtra por Nombre");
		lblRead1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblRead1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRead1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblRead1 = new GridBagConstraints();
		gbc_lblRead1.anchor = GridBagConstraints.EAST;
		gbc_lblRead1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRead1.gridx = 2;
		gbc_lblRead1.gridy = 4;
		panel_consultar_cliente.add(lblRead1, gbc_lblRead1);
		
		tfRead1 = new JTextField();
		tfRead1.setToolTipText("Introduce Nombre");
		tfRead1.setMaximumSize(new Dimension(250, 250));
		tfRead1.setColumns(10);
		GridBagConstraints gbc_tfRead1 = new GridBagConstraints();
		gbc_tfRead1.fill = GridBagConstraints.BOTH;
		gbc_tfRead1.insets = new Insets(0, 0, 5, 5);
		gbc_tfRead1.gridx = 3;
		gbc_tfRead1.gridy = 4;
		panel_consultar_cliente.add(tfRead1, gbc_tfRead1);
		
		JButton btnNewButton = new JButton("Buscar ");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(MainView.class.getResource("/resources/assets/icons/lupa.png")));
		btnNewButton.setActionCommand("");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 4;
		panel_consultar_cliente.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblRead2 = new JLabel("Filtra por DNI");
		lblRead2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRead2.setForeground(Color.WHITE);
		lblRead2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRead2 = new GridBagConstraints();
		gbc_lblRead2.anchor = GridBagConstraints.EAST;
		gbc_lblRead2.insets = new Insets(0, 0, 5, 5);
		gbc_lblRead2.gridx = 2;
		gbc_lblRead2.gridy = 5;
		panel_consultar_cliente.add(lblRead2, gbc_lblRead2);
		
		tfRead2 = new JTextField();
		tfRead2.setToolTipText("Introduce Nombre");
		tfRead2.setMaximumSize(new Dimension(250, 250));
		tfRead2.setColumns(10);
		GridBagConstraints gbc_tfRead2 = new GridBagConstraints();
		gbc_tfRead2.insets = new Insets(0, 0, 5, 5);
		gbc_tfRead2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRead2.gridx = 3;
		gbc_tfRead2.gridy = 5;
		panel_consultar_cliente.add(tfRead2, gbc_tfRead2);
		
		
		
		tableClients = new JTable();
		tableClients.setColumnSelectionAllowed(true);
		tableClients.setCellSelectionEnabled(true);
		GridBagConstraints gbc_tableClients = new GridBagConstraints();
		gbc_tableClients.gridheight = 3;
		gbc_tableClients.insets = new Insets(0, 0, 0, 5);
		gbc_tableClients.fill = GridBagConstraints.BOTH;
		gbc_tableClients.gridwidth = 5;
		gbc_tableClients.gridx = 1;
		gbc_tableClients.gridy = 7;
		panel_consultar_cliente.add(tableClients, gbc_tableClients);
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
