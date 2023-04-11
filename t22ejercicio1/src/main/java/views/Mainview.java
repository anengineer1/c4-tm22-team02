package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;

public class Mainview extends JFrame {


	private JPanel contentPane;
	private JTextField tfCreate1;
	private JTextField tfCreate3;
	private JTextField tfCreate2;
	private JTextField tfCreate4;


	/**
	 * Create the frame.
	 */
	public Mainview() {
		setTitle("TEAM02: Ejercicio1 - Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{723, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 494, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JLabel lblNewLabel = new JLabel("GESTION DE CLIENTES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 2;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel_crear_cliente = new JPanel();
		panel_crear_cliente.setForeground(new Color(255, 255, 255));
		panel_crear_cliente.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		panel_crear_cliente.setToolTipText("");
		panel_crear_cliente.setName("");
		panel_crear_cliente.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Dar de alta Cliente", null, panel_crear_cliente, "Alta de Cliente");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		GridBagLayout gbl_panel_crear_cliente = new GridBagLayout();
		gbl_panel_crear_cliente.columnWidths = new int[]{400, 0, 96, 0, 0, 0};
		gbl_panel_crear_cliente.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_crear_cliente.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_crear_cliente.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_crear_cliente.setLayout(gbl_panel_crear_cliente);
		
		JLabel lblNewLabel_2 = new JLabel("Alta de cliente");
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setToolTipText("Alta cliente");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_crear_cliente.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblCreate1 = new JLabel("Nombre");
		lblCreate1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblCreate1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblCreate1 = new GridBagConstraints();
		gbc_lblCreate1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreate1.anchor = GridBagConstraints.EAST;
		gbc_lblCreate1.gridx = 0;
		gbc_lblCreate1.gridy = 2;
		panel_crear_cliente.add(lblCreate1, gbc_lblCreate1);
		
		tfCreate1 = new JTextField();
		tfCreate1.setMaximumSize(new Dimension(250, 250));
		tfCreate1.setToolTipText("Introduce Nombre");
		GridBagConstraints gbc_tfCreate1 = new GridBagConstraints();
		gbc_tfCreate1.insets = new Insets(0, 0, 5, 5);
		gbc_tfCreate1.anchor = GridBagConstraints.NORTHWEST;
		gbc_tfCreate1.gridx = 1;
		gbc_tfCreate1.gridy = 2;
		panel_crear_cliente.add(tfCreate1, gbc_tfCreate1);
		tfCreate1.setColumns(10);
		
		JLabel lblCreate2 = new JLabel("Apellidos");
		lblCreate2.setToolTipText("Apellidos Cliente");
		lblCreate2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate2.setForeground(Color.WHITE);
		lblCreate2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCreate2 = new GridBagConstraints();
		gbc_lblCreate2.anchor = GridBagConstraints.EAST;
		gbc_lblCreate2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreate2.gridx = 0;
		gbc_lblCreate2.gridy = 3;
		panel_crear_cliente.add(lblCreate2, gbc_lblCreate2);
		
		tfCreate2 = new JTextField();
		tfCreate2.setToolTipText("Introduce Apellidos");
		tfCreate2.setMaximumSize(new Dimension(250, 250));
		tfCreate2.setColumns(10);
		GridBagConstraints gbc_tfCreate2 = new GridBagConstraints();
		gbc_tfCreate2.insets = new Insets(0, 0, 5, 5);
		gbc_tfCreate2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCreate2.gridx = 1;
		gbc_tfCreate2.gridy = 3;
		panel_crear_cliente.add(tfCreate2, gbc_tfCreate2);
		
		JLabel lblCreate3 = new JLabel("Dirección");
		lblCreate3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate3.setForeground(Color.WHITE);
		lblCreate3.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCreate3 = new GridBagConstraints();
		gbc_lblCreate3.anchor = GridBagConstraints.EAST;
		gbc_lblCreate3.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreate3.gridx = 0;
		gbc_lblCreate3.gridy = 4;
		panel_crear_cliente.add(lblCreate3, gbc_lblCreate3);
		
		tfCreate3 = new JTextField();
		tfCreate3.setToolTipText("Introduce Dirección");
		tfCreate3.setMaximumSize(new Dimension(250, 250));
		tfCreate3.setColumns(10);
		GridBagConstraints gbc_tfCreate3 = new GridBagConstraints();
		gbc_tfCreate3.insets = new Insets(0, 0, 5, 5);
		gbc_tfCreate3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCreate3.gridx = 1;
		gbc_tfCreate3.gridy = 4;
		panel_crear_cliente.add(tfCreate3, gbc_tfCreate3);
		
		JLabel lblCreate4 = new JLabel("DNI");
		lblCreate4.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate4.setForeground(Color.WHITE);
		lblCreate4.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCreate4 = new GridBagConstraints();
		gbc_lblCreate4.anchor = GridBagConstraints.EAST;
		gbc_lblCreate4.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreate4.gridx = 0;
		gbc_lblCreate4.gridy = 5;
		panel_crear_cliente.add(lblCreate4, gbc_lblCreate4);
		
		tfCreate4 = new JTextField();
		tfCreate4.setToolTipText("Introduce DNI");
		tfCreate4.setMaximumSize(new Dimension(250, 250));
		tfCreate4.setColumns(10);
		GridBagConstraints gbc_tfCreate4 = new GridBagConstraints();
		gbc_tfCreate4.insets = new Insets(0, 0, 5, 5);
		gbc_tfCreate4.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCreate4.gridx = 1;
		gbc_tfCreate4.gridy = 5;
		panel_crear_cliente.add(tfCreate4, gbc_tfCreate4);
		
		JLabel lblCreate5 = new JLabel(" Fecha Alta");
		lblCreate5.setVerticalAlignment(SwingConstants.TOP);
		lblCreate5.setToolTipText("Introduce Fecha de Alta de Cliente");
		lblCreate5.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate5.setForeground(Color.WHITE);
		lblCreate5.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCreate5 = new GridBagConstraints();
		gbc_lblCreate5.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblCreate5.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreate5.gridx = 0;
		gbc_lblCreate5.gridy = 6;
		panel_crear_cliente.add(lblCreate5, gbc_lblCreate5);
		
		JCalendar jcFechaAlta = new JCalendar();
		GridBagConstraints gbc_jcFechaAlta = new GridBagConstraints();
		gbc_jcFechaAlta.anchor = GridBagConstraints.WEST;
		gbc_jcFechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_jcFechaAlta.gridx = 1;
		gbc_jcFechaAlta.gridy = 6;
		panel_crear_cliente.add(jcFechaAlta, gbc_jcFechaAlta);
		
		JButton btnNewButton = new JButton("Finalizar Alta de Cliente");
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 8;
		panel_crear_cliente.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_consultar_cliente = new JPanel();
		panel_consultar_cliente.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Consulta Cliente", null, panel_consultar_cliente, "Consulta Cliente");
		tabbedPane.setEnabledAt(1, true);
		
		JPanel panel_actualizar_cliente = new JPanel();
		panel_actualizar_cliente.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Actualizar Cliente", null, panel_actualizar_cliente, null);
		
		JPanel panel_borrar_cliente = new JPanel();
		panel_borrar_cliente.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("New tab", null, panel_borrar_cliente, null);
		
		
		
	}

}
