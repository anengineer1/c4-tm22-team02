package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertScientistView extends JPanel {
	private JTextField inputDNIScientist;
	private JTextField inputNomApels;

	private JLabel labelDNIScientist;
	private JLabel labelNomApels;

	public InsertScientistView() {

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

}
