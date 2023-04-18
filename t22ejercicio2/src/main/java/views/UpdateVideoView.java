/**
 * 
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * @author Marc RG
 *
 */
public class UpdateVideoView extends JPanel {
	
	public JPanel contentPane;
	public JTextField tfCreate1;
	public JTextField tfCreate2;
	public JTextField tfCreate3;
	public JButton btnModVideo;
	public JTable table;
	
	public UpdateVideoView() {
		this.setForeground(new Color(255, 255, 255));
		this.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		this.setToolTipText("");
		this.setName("");
		this.setBackground(new Color(0, 64, 128));
		this.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Modificacion de video");
		lblNewLabel_2.setBounds(96, 69, 142, 26);
		
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setToolTipText("Alta cliente");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		this.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(103, 179, 128, 128);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/resources/assets/icons/add-client128.png")));
		this.add(lblNewLabel);
		
		JLabel lblCreate1 = new JLabel("Titulo");
		lblCreate1.setBounds(292, 105, 47, 16);
		lblCreate1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblCreate1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate1.setForeground(new Color(255, 255, 255));
		this.add(lblCreate1);
		
		tfCreate1 = new JTextField();
		tfCreate1.setBounds(344, 100, 280, 27);
		tfCreate1.setMaximumSize(new Dimension(250, 250));
		tfCreate1.setToolTipText("Introduce Titulo");
		this.add(tfCreate1);
		tfCreate1.setColumns(10);
		
		JLabel lblCreate2 = new JLabel("DNI Cliente actual");
		lblCreate2.setBounds(286, 137, 53, 16);
		lblCreate2.setToolTipText("DNI actual");
		lblCreate2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate2.setForeground(Color.WHITE);
		lblCreate2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		this.add(lblCreate2);
		
		tfCreate2 = new JTextField();
		tfCreate2.setBounds(344, 132, 280, 27);
		tfCreate2.setToolTipText("Introduce DNI actual");
		tfCreate2.setMaximumSize(new Dimension(250, 250));
		tfCreate2.setColumns(10);
		this.add(tfCreate2);
		
		JLabel lblCreate3 = new JLabel("DNI Cliente nuevo");
		lblCreate3.setBounds(283, 169, 56, 16);
		lblCreate3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreate3.setForeground(Color.WHITE);
		lblCreate3.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		this.add(lblCreate3);
		
		tfCreate3 = new JTextField();
		tfCreate3.setBounds(344, 164, 280, 27);
		tfCreate3.setToolTipText("Introduce DNI nuevo");
		tfCreate3.setMaximumSize(new Dimension(250, 250));
		tfCreate3.setColumns(10);
		this.add(tfCreate3);
		
		btnModVideo = new JButton("Modificar video");
		btnModVideo.setBounds(344, 421, 280, 55);
		btnModVideo.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		btnModVideo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		btnModVideo.setBackground(new Color(255, 255, 255));
		this.add(btnModVideo);
	}
	
	public JPanel getPanel_crear_video() {
		return this;
	}

}
