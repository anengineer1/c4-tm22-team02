package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteProjectView extends JPanel {

	private JTextField inputIdProject;

	private JLabel labelIdProject;

	public DeleteProjectView() {

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

	}

	public String getIdProject() {
		return this.inputIdProject.getText();
	}

}
