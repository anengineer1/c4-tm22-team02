package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteScientistView extends JPanel {
	private JTextField inputDNIScientist;

	private JLabel labelDNIScientist;

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

	}
	
	public String getScientistDNI() {
		return this.inputDNIScientist.getText();
	}

}
