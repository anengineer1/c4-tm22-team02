package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;

public class UpdateClientView extends JPanel {

	public JTextField tfUpdate1;
	public JTextField tfUpdate3;
	public JTextField tfUpdate2;
	public JTextField tfUpdate4;
	public JButton btnNewButton1;
	public JButton btnNewButton2;

	/**
	 * Create the panel.
	 */
	public UpdateClientView() {

		this.setForeground(new Color(255, 255, 255));
		this.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		this.setToolTipText("Actualizar datos de usuario");
		this.setName("");
		this.setBackground(new Color(0, 64, 128));
		this.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Actualizar Cliente");
		lblNewLabel_2.setBounds(96, 69, 185, 26);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setToolTipText("Actualizar Cliente");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		this.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(103, 179, 128, 128);
		lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/resources/assets/icons/update-client.png")));
		this.add(lblNewLabel);

		JLabel lblCreate1 = new JLabel("Nombre");
		lblCreate1.setBounds(292, 105, 47, 16);
		lblCreate1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblCreate1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate1.setForeground(new Color(255, 255, 255));
		this.add(lblCreate1);

		tfUpdate1 = new JTextField();
		tfUpdate1.setBounds(344, 100, 280, 27);
		tfUpdate1.setMaximumSize(new Dimension(250, 250));
		tfUpdate1.setToolTipText("Introduce Nombre");
		this.add(tfUpdate1);
		tfUpdate1.setColumns(10);

		JLabel lblCreate2 = new JLabel("Apellidos");
		lblCreate2.setBounds(286, 137, 53, 16);
		lblCreate2.setToolTipText("Apellidos Cliente");
		lblCreate2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate2.setForeground(Color.WHITE);
		lblCreate2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		this.add(lblCreate2);

		tfUpdate2 = new JTextField();
		tfUpdate2.setBounds(344, 132, 280, 27);
		tfUpdate2.setToolTipText("Introduce Apellidos");
		tfUpdate2.setMaximumSize(new Dimension(250, 250));
		tfUpdate2.setColumns(10);
		this.add(tfUpdate2);

		JLabel lblCreate3 = new JLabel("Dirección");
		lblCreate3.setBounds(283, 169, 56, 16);
		lblCreate3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate3.setForeground(Color.WHITE);
		lblCreate3.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		this.add(lblCreate3);

		tfUpdate3 = new JTextField();
		tfUpdate3.setBounds(344, 164, 280, 27);
		tfUpdate3.setToolTipText("Introduce Dirección");
		tfUpdate3.setMaximumSize(new Dimension(250, 250));
		tfUpdate3.setColumns(10);
		this.add(tfUpdate3);

		JLabel lblCreate4 = new JLabel("DNI");
		lblCreate4.setBounds(317, 201, 22, 16);
		lblCreate4.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate4.setForeground(Color.WHITE);
		lblCreate4.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		this.add(lblCreate4);

		tfUpdate4 = new JTextField();
		tfUpdate4.setBounds(344, 196, 280, 26);
		tfUpdate4.setToolTipText("Introduce DNI");
		tfUpdate4.setMaximumSize(new Dimension(250, 250));
		tfUpdate4.setColumns(10);
		this.add(tfUpdate4);
		
		btnNewButton2 = new JButton("Buscar Cliente");
		btnNewButton2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		btnNewButton2.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		btnNewButton2.setBackground(Color.WHITE);
		btnNewButton2.setBounds(344, 256, 280, 55);
		add(btnNewButton2);


		btnNewButton1 = new JButton("Actualizar Datos de Cliente");
		btnNewButton1.setBounds(344, 421, 280, 55);
		btnNewButton1.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		btnNewButton1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		btnNewButton1.setBackground(new Color(255, 255, 255));
		this.add(btnNewButton1);
	}

}
