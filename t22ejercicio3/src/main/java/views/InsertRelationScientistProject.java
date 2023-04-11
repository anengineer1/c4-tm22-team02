package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertRelationScientistProject extends JPanel {
	private JTextField inputDNIScientist;
	private JTextField inputProjectId;

	private JLabel labelDNIScientist;
	private JLabel labelProjectId;

	public InsertRelationScientistProject() {

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

		this.labelProjectId = new JLabel("Id Projecto");
		this.labelProjectId.setBounds(10, 50, 150, 30);
		this.add(this.labelProjectId);

		this.inputProjectId = new JTextField();
		this.inputProjectId.setBounds(160, 50, 120, 30);
		this.add(this.inputProjectId);

	}
	
	public String getScientistDNI() {
		return this.inputDNIScientist.getText();
	}
	
	public String getProjectId() {
		return this.inputProjectId.getText();
	}

}
