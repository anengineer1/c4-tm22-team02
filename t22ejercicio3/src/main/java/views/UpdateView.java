package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class UpdateView extends JPanel {
	private JButton updateButton;

	private UpdateScientistView updateScientistView;
	private UpdateProjectView updateProjectView;
	private UpdateRelationScientistProject updateRelationScientistProject;

	public UpdateView() {
		initInterface();
	}

	private void initInterface() {
		setLayout(new MigLayout("", "[300px,grow][300px][300px]", "[150px][30px][248.00,grow]"));

		this.updateScientistView = new UpdateScientistView();
		this.add(this.updateScientistView, "cell 0 0,grow");

		this.updateProjectView = new UpdateProjectView();
		this.add(this.updateProjectView, "cell 1 0,grow");

		this.updateRelationScientistProject = new UpdateRelationScientistProject();
		this.add(this.updateRelationScientistProject, "cell 2 0,grow");

		// Add button
		this.updateButton = new JButton("Update");
		this.add(updateButton, "cell 0 1,alignx left,growy");

	}

	public String getScientistDNI() {
		return this.updateScientistView.getScientistDNI();
	}

	public String getScientistNomApels() {
		return this.updateScientistView.getNomApels();
	}

	public String getIdProject() {
		return this.updateProjectView.getIdProject();
	}

	public String getProjectName() {
		return this.updateProjectView.getProjectName();
	}

	public String getProjectHours() {
		return this.updateProjectView.getHours();
	}

	public String getAssignedToDNI() {
		return this.updateRelationScientistProject.getScientistDNI();
	}

	public String getAssignedToProjectId() {
		return this.updateRelationScientistProject.getProjectId();
	}

	public JButton getButton() {
		return this.updateButton;
	}
}
