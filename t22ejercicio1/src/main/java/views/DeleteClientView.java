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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author elena-01
 *
 */
public class DeleteClientView  extends JPanel {


	public JTextField tfDelete1;
	public JButton btnNewButton;

	/**
	 * 
	 */
	public DeleteClientView() {
		this.setToolTipText("Eliminacion de cliente en base de datos");
		this.setBackground(new Color(0, 64, 128));
				setLayout(null);
		// Label Tab Read Client
				JLabel lbl_elimina_cliente = new JLabel("Eliminacion cliente");
				lbl_elimina_cliente.setHorizontalTextPosition(SwingConstants.RIGHT);
				lbl_elimina_cliente.setBounds(83, 74, 319, 128);
				lbl_elimina_cliente.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				lbl_elimina_cliente
						.setIcon(new ImageIcon(MainView.class.getResource("/resources/assets/icons/delete.png")));
				lbl_elimina_cliente.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_elimina_cliente.setToolTipText("Consulta cliente");
				lbl_elimina_cliente.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
				lbl_elimina_cliente.setForeground(new Color(255, 255, 255));
				this.add(lbl_elimina_cliente);
				
				
				
				JLabel lblRead1 = new JLabel("Filtra por DNI");
				lblRead1.setBounds(312, 197, 135, 16);
				lblRead1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
				lblRead1.setHorizontalAlignment(SwingConstants.CENTER);
				lblRead1.setForeground(new Color(255, 255, 255));
				this.add(lblRead1);

				tfDelete1 = new JTextField();
				tfDelete1.setBounds(322, 234, 135, 20);
				tfDelete1.setToolTipText("Introduce Nombre");
				tfDelete1.setMaximumSize(new Dimension(250, 250));
				tfDelete1.setColumns(10);
				this.add(tfDelete1);
				
				btnNewButton = new JButton("Eliminar cliente ");
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnNewButton.setBounds(322, 283, 135, 49);
				btnNewButton.setBorder(null);
				btnNewButton.setActionCommand("");
				this.add(btnNewButton);
	}

}
