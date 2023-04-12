package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

public class LookUpView extends JPanel {
	private JButton lookButton;

	private LookUpScientistView lookUpScientistView;
	private LookUpProjectView lookUpProjectView;
	private LookUpRelationScientistProject lookUpRelationScientistProject;

	private JTextArea output;

	public LookUpView() {
		initInterface();
	}

	private void initInterface() {
		setLayout(new MigLayout("", "[300px][300px][300px]", "[150px][30px][248.00]"));

		this.lookUpScientistView = new LookUpScientistView();
		this.add(this.lookUpScientistView, "cell 0 0,grow");

		this.lookUpProjectView = new LookUpProjectView();
		this.add(this.lookUpProjectView, "cell 1 0,grow");

		this.lookUpRelationScientistProject = new LookUpRelationScientistProject();
		this.add(this.lookUpRelationScientistProject, "cell 2 0,grow");

		// Add button
		this.lookButton = new JButton("Consulta");
		this.add(lookButton, "cell 0 1,alignx left,growy");

		// Add textPane
		this.output = new JTextArea();
		this.add(this.output, "cell 0 2 3 1,grow");
	}

	public String getScientistDNI() {
		return this.lookUpScientistView.getScientistDNI();
	}

	public String getScientistNomApels() {
		return this.lookUpScientistView.getNomApels();
	}

	public String getIdProject() {
		return this.lookUpProjectView.getIdProject();
	}

	public String getProjectName() {
		return this.lookUpProjectView.getProjectName();
	}

	public String getProjectHours() {
		return this.lookUpProjectView.getHours();
	}

	public String getAssignedToDNI() {
		return this.lookUpRelationScientistProject.getScientistDNI();
	}

	public String getAssignedToProjectId() {
		return this.lookUpRelationScientistProject.getProjectId();
	}
	
	public void setResults(String results) {
		this.output.setText(results);
	}
	
	public JButton getButton() {
		return this.lookButton;
	}
}
