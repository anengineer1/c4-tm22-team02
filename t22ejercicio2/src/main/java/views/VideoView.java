package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;

public class VideoView extends JFrame {

	public JPanel contentPane;
	public JTextField tfCreate1;
	public JTextField tfCreate2;
	public JTextField tfCreate3;
	public JButton btnAddVideo;
	public JTable table;

	/**
	 * Create the frame.
	 */
	public VideoView() {
		setTitle("TEAM02: Ejercicio1 - Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 723, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 494, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);

		JLabel lblNewLabel = new JLabel("GESTION DE VIDEOS");
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

		JPanel panel_crear_video = new JPanel();
		panel_crear_video.setForeground(new Color(255, 255, 255));
		panel_crear_video.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		panel_crear_video.setToolTipText("");
		panel_crear_video.setName("");
		panel_crear_video.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Añadir video", null, panel_crear_video, "Añadir nuevo video");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		GridBagLayout gbl_panel_crear_cliente = new GridBagLayout();
		gbl_panel_crear_cliente.columnWidths = new int[] { 400, 0, 96, 0, 0, 0 };
		gbl_panel_crear_cliente.rowHeights = new int[] { 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_crear_cliente.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_crear_cliente.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_crear_video.setLayout(gbl_panel_crear_cliente);

		JLabel lblNewLabel_2 = new JLabel("Añadir nuevo video");
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setToolTipText("Nuevo video");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_crear_video.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblCreate1 = new JLabel("Titulo");
		lblCreate1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblCreate1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblCreate1 = new GridBagConstraints();
		gbc_lblCreate1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreate1.anchor = GridBagConstraints.EAST;
		gbc_lblCreate1.gridx = 0;
		gbc_lblCreate1.gridy = 2;
		panel_crear_video.add(lblCreate1, gbc_lblCreate1);

		tfCreate1 = new JTextField();
		tfCreate1.setMaximumSize(new Dimension(250, 250));
		tfCreate1.setToolTipText("Introduce título");
		GridBagConstraints gbc_tfCreate1 = new GridBagConstraints();
		gbc_tfCreate1.insets = new Insets(0, 0, 5, 5);
		gbc_tfCreate1.anchor = GridBagConstraints.NORTHWEST;
		gbc_tfCreate1.gridx = 1;
		gbc_tfCreate1.gridy = 2;
		panel_crear_video.add(tfCreate1, gbc_tfCreate1);
		tfCreate1.setColumns(10);

		JLabel lblCreate2 = new JLabel("Director");
		lblCreate2.setToolTipText("Director película");
		lblCreate2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate2.setForeground(Color.WHITE);
		lblCreate2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCreate2 = new GridBagConstraints();
		gbc_lblCreate2.anchor = GridBagConstraints.EAST;
		gbc_lblCreate2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreate2.gridx = 0;
		gbc_lblCreate2.gridy = 3;
		panel_crear_video.add(lblCreate2, gbc_lblCreate2);

		tfCreate2 = new JTextField();
		tfCreate2.setToolTipText("Introduce director");
		tfCreate2.setMaximumSize(new Dimension(250, 250));
		tfCreate2.setColumns(10);
		GridBagConstraints gbc_tfCreate2 = new GridBagConstraints();
		gbc_tfCreate2.insets = new Insets(0, 0, 5, 5);
		gbc_tfCreate2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCreate2.gridx = 1;
		gbc_tfCreate2.gridy = 3;
		panel_crear_video.add(tfCreate2, gbc_tfCreate2);

		JLabel lblCreate3 = new JLabel("Cliente");
		lblCreate3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate3.setForeground(Color.WHITE);
		lblCreate3.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCreate3 = new GridBagConstraints();
		gbc_lblCreate3.anchor = GridBagConstraints.EAST;
		gbc_lblCreate3.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreate3.gridx = 0;
		gbc_lblCreate3.gridy = 4;
		panel_crear_video.add(lblCreate3, gbc_lblCreate3);

		tfCreate3 = new JTextField();
		tfCreate3.setToolTipText("Introduce cliente");
		tfCreate3.setMaximumSize(new Dimension(250, 250));
		tfCreate3.setColumns(10);
		GridBagConstraints gbc_tfCreate3 = new GridBagConstraints();
		gbc_tfCreate3.insets = new Insets(0, 0, 5, 5);
		gbc_tfCreate3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCreate3.gridx = 1;
		gbc_tfCreate3.gridy = 4;
		panel_crear_video.add(tfCreate3, gbc_tfCreate3);
		

		btnAddVideo = new JButton("Añadir");
		btnAddVideo.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		btnAddVideo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		btnAddVideo.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		panel_crear_video.add(btnAddVideo, gbc_btnNewButton);

		JPanel panel_consultar_videos = new JPanel();
		panel_consultar_videos.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Consulta Videos", null, panel_consultar_videos, "Consulta Videos");
		panel_consultar_videos.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 896, 503);
		panel_consultar_videos.add(scrollPane);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(0, 0, 677, 243);
		panel_consultar_videos.add(table);
		tabbedPane.setEnabledAt(1, true);

		JPanel panel_actualizar_video = new JPanel();
		panel_actualizar_video.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Actualizar video", null, panel_actualizar_video, null);

		JPanel panel_borrar_video = new JPanel();
		panel_borrar_video.setBackground(new Color(0, 64, 128));
		tabbedPane.addTab("Borrar video", null, panel_borrar_video, null);

	}
}