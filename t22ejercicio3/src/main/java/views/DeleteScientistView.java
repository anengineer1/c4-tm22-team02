package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteScientistView extends JPanel {
	private JTextField inputDNIScientist;
	private JTextField inputNomApels;

	private JLabel labelDNIScientist;
	private JLabel labelNomApels;

	public DeleteScientistView() {

		initializeView();
	}

	private void initializeView() {
		this.setBounds(100, 100, 400, 300);
		this.setLayout(null);

		this.labelDNIScientist = new JLabel("DNI");
		this.labelDNIScientist.setBounds(10, 10, 150, 30);
		this.add(this.labelDNIScientist);

		this.inputDNIScientist = new JTextField();
		this.inputDNIScientist.setBounds(160, 10, 120, 30);
		this.add(this.inputDNIScientist);

		this.labelNomApels = new JLabel("Nombre completo");
		this.labelNomApels.setBounds(10, 50, 150, 30);
		this.add(this.labelNomApels);

		this.inputNomApels = new JTextField();
		this.inputNomApels.setBounds(160, 50, 120, 30);
		this.add(this.inputNomApels);

	}
	
	public String getScientistDNI() {
		return this.inputDNIScientist.getText();
	}
	
	public String getNomApels() {
		return this.inputNomApels.getText();
	}

}
