/**
 * 
 */
package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author elena-01
 *
 */
public class ReadClientView extends JPanel {

	public JTextField tfRead1;
	public JTextField tfRead2;
	public JButton btnNewButton;
	public JTable tableClients;

	/**
	 * 
	 */
	public ReadClientView() {
	
		this.setToolTipText("Consulta de cliente en base de datos");
		this.setBackground(new Color(0, 64, 128));
		//this.setLayout(null);

		// Label Tab Read Client
		JLabel lbl_consulta_cliente = new JLabel("Consulta cliente");
		lbl_consulta_cliente.setBounds(175, 60, 431, 128);
		lbl_consulta_cliente.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		lbl_consulta_cliente
				.setIcon(new ImageIcon(MainView.class.getResource("/resources/assets/icons/read-client.png")));
		lbl_consulta_cliente.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_consulta_cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_consulta_cliente.setToolTipText("Consulta cliente");
		lbl_consulta_cliente.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lbl_consulta_cliente.setForeground(new Color(255, 255, 255));
		this.add(lbl_consulta_cliente);

		JLabel lblRead1 = new JLabel("Filtra por Nombre");
		lblRead1.setBounds(303, 225, 103, 16);
		lblRead1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblRead1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRead1.setForeground(new Color(255, 255, 255));
		this.add(lblRead1);

		tfRead1 = new JTextField();
		tfRead1.setBounds(411, 223, 195, 20);
		tfRead1.setToolTipText("Introduce Nombre");
		tfRead1.setMaximumSize(new Dimension(250, 250));
		tfRead1.setColumns(10);
		this.add(tfRead1);

		btnNewButton = new JButton("Buscar ");
		btnNewButton.setBounds(611, 223, 135, 49);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(MainView.class.getResource("/resources/assets/icons/lupa.png")));
		btnNewButton.setActionCommand("");
		this.add(btnNewButton);

		JLabel lblRead2 = new JLabel("Filtra por DNI");
		lblRead2.setBounds(328, 252, 78, 16);
		lblRead2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRead2.setForeground(Color.WHITE);
		lblRead2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		this.add(lblRead2);

		tfRead2 = new JTextField();
		tfRead2.setBounds(411, 250, 195, 20);
		tfRead2.setToolTipText("Introduce Nombre");
		tfRead2.setMaximumSize(new Dimension(250, 250));
		tfRead2.setColumns(10);
		this.add(tfRead2);

		tableClients = new JTable();
		tableClients.setBounds(47, 307, 796, 247);
		tableClients.setColumnSelectionAllowed(true);
		tableClients.setCellSelectionEnabled(true);
		this.add(tableClients);

	}
}
