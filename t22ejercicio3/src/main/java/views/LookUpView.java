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

public class LookUpView extends JPanel {
	private JButton lookButton;

	private LookUpScientistView lookUpScientistView;
	private LookUpProjectView lookUpProjectView;
	private LookUpRelationScientistProject lookUpRelationScientistProject;

	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;

	public LookUpView() {
		initInterface();
	}

	private void initInterface() {
		setLayout(new MigLayout("", "[300px,grow][300px][300px]", "[150px][30px][248.00,grow]"));

		this.lookUpScientistView = new LookUpScientistView();
		this.add(this.lookUpScientistView, "cell 0 0,grow");

		this.lookUpProjectView = new LookUpProjectView();
		this.add(this.lookUpProjectView, "cell 1 0,grow");

		this.lookUpRelationScientistProject = new LookUpRelationScientistProject();
		this.add(this.lookUpRelationScientistProject, "cell 2 0,grow");

		// Add button
		this.lookButton = new JButton("Consulta");
		this.add(lookButton, "cell 0 1,alignx left,growy");

		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 2 3 1,grow");

		table = new JTable();
		this.model = new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "DNI", "Nom Apels", "Id Proyecto", "Nombre Proyecto", "Horas" });
		table.setModel(this.model);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);

		// Add textPane
//		this.output = new JTextArea();
//		this.add(this.output, "cell 0 2 3 1,grow");
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

	public void setRow(String DNI, String nom_apels, String id_proj, String nombre_proy, String horas_proy) {
		this.model.addRow(new Object[] {DNI, nom_apels, id_proj, nombre_proy, horas_proy});
	}
	
	public void clearRows() {
		this.model.setRowCount(0);
	}

	public JButton getButton() {
		return this.lookButton;
	}
}
