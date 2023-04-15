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

public class DeleteView extends JPanel {
	private JButton lookButton;

	private DeleteScientistView deleteScientistView;
	private DeleteProjectView deleteProjectView;
	private DeleteRelationScientistProject deleteRelationScientistProject;

	public DeleteView() {
		initInterface();
	}

	private void initInterface() {
		setLayout(new MigLayout("", "[300px,grow][300px][300px]", "[150px][30px][248.00,grow]"));

		this.deleteScientistView = new DeleteScientistView();
		this.add(this.deleteScientistView, "cell 0 0,grow");

		this.deleteProjectView = new DeleteProjectView();
		this.add(this.deleteProjectView, "cell 1 0,grow");

		this.deleteRelationScientistProject = new DeleteRelationScientistProject();
		this.add(this.deleteRelationScientistProject, "cell 2 0,grow");

		// Add button
		this.lookButton = new JButton("Borrar");
		this.add(lookButton, "cell 0 1,alignx left,growy");

	}

	public String getScientistDNI() {
		return this.deleteScientistView.getScientistDNI();
	}

	public String getScientistNomApels() {
		return this.deleteScientistView.getNomApels();
	}

	public String getIdProject() {
		return this.deleteProjectView.getIdProject();
	}

	public String getProjectName() {
		return this.deleteProjectView.getProjectName();
	}

	public String getProjectHours() {
		return this.deleteProjectView.getHours();
	}

	public String getAssignedToDNI() {
		return this.deleteRelationScientistProject.getScientistDNI();
	}

	public String getAssignedToProjectId() {
		return this.deleteRelationScientistProject.getProjectId();
	}

	public JButton getButton() {
		return this.lookButton;
	}
}
