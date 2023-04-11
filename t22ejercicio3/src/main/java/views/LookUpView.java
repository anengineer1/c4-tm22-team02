package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class LookUpView extends JPanel {
	private JButton insertButton;

	private LookUpScientistView lookUpScientistView;
	private LookUpProjectView lookUpProjectView;
	private LookUpRelationScientistProject lookUpRelationScientistProject;

	private JTextArea output;
	
	public LookUpView() {
		initInterface();
	}

	private void initInterface() {
		this.setLayout(null);

		this.lookUpScientistView = new LookUpScientistView();
		this.lookUpScientistView.setBounds(10, 10, 300, 150);
		this.add(this.lookUpScientistView);

		this.lookUpProjectView = new LookUpProjectView();
		this.lookUpProjectView.setBounds(350, 10, 300, 150);
		this.add(this.lookUpProjectView);

		this.lookUpRelationScientistProject = new LookUpRelationScientistProject();
		this.lookUpRelationScientistProject.setBounds(700, 10, 300, 150);
		this.add(this.lookUpRelationScientistProject);

		// Add button
		this.insertButton = new JButton("Consulta");
		this.insertButton.setBounds(10, 300, 150, 30);
		this.add(insertButton);
		
		// Add textPane
		this.output = new JTextArea();
		this.output.setBounds(10, 350, 1000, 250);
		this.add(this.output);
	}

}
