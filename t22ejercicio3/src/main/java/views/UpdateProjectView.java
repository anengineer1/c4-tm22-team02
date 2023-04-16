package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateProjectView extends JPanel {

	private JTextField inputIdProject;
	private JTextField inputProjectName;
	private JTextField inputHours;

	private JLabel labelIdProject;
	private JLabel labelProjectName;
	private JLabel labelHours;

	public UpdateProjectView() {

		initializeView();
	}

	private void initializeView() {
		this.setBounds(350, 100, 400, 300);
		this.setLayout(null);

		this.labelIdProject = new JLabel("Id Proyecto");
		this.labelIdProject.setBounds(10, 10, 150, 30);
		this.add(this.labelIdProject);

		this.inputIdProject = new JTextField();
		this.inputIdProject.setBounds(160, 10, 120, 30);
		this.add(this.inputIdProject);

		this.labelProjectName = new JLabel("Nombre de proyecto");
		this.labelProjectName.setBounds(10, 50, 150, 30);
		this.add(this.labelProjectName);

		this.inputProjectName = new JTextField();
		this.inputProjectName.setBounds(160, 50, 120, 30);
		this.add(this.inputProjectName);

		this.labelHours = new JLabel("Número de horas");
		this.labelHours.setBounds(10, 90, 150, 30);
		this.add(this.labelHours);

		this.inputHours = new JTextField();
		this.inputHours.setBounds(160, 90, 120, 30);
		this.add(this.inputHours);

	}

	public String getIdProject() {
		return this.inputIdProject.getText();
	}

	public String getProjectName() {
		return this.inputProjectName.getText();
	}

	public String getHours() {
		return this.inputHours.getText();
	}

}
