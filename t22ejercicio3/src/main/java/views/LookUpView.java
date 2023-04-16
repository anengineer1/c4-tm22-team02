package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class LookUpView extends JPanel {
	private JButton lookButton;

	private LookUpScientistView lookUpScientistView;
	private LookUpProjectView lookUpProjectView;
	private LookUpRelationScientistProject lookUpRelationScientistProject;

	private JScrollPane scrollPane;
	private JTable table;
	private JButton scientistButton;
	private JButton projectButton;
	private JButton assignedToButton;

	private DefaultTableModel currentModel;
	private DefaultTableModel joinModel;
	private DefaultTableModel scientistModel;
	private DefaultTableModel projectModel;
	private DefaultTableModel assignedModel;

	public LookUpView() {
		initModels();
		initInterface();
	}

	public void initModels() {
		this.joinModel = new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "DNI", "Nom Apels", "Id Proyecto", "Nombre Proyecto", "Horas" });
		this.joinModel.setRowCount(0);

		this.scientistModel = new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "DNI", "Nom Apels" });
		this.scientistModel.setRowCount(0);

		this.projectModel = new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Id Proyecto", "Nombre Proyecto", "Horas" });
		this.projectModel.setRowCount(0);
		
		this.assignedModel = new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "DNI", "Id Proyecto" });
		this.assignedModel.setRowCount(0);

		this.currentModel = this.joinModel;
	}

	private void initInterface() {
		setLayout(new MigLayout("", "[300px,grow][300px][300px]", "[150px][30px][248.00,grow]"));

		this.lookUpScientistView = new LookUpScientistView();
		this.add(this.lookUpScientistView, "cell 0 0,grow");

		this.lookUpProjectView = new LookUpProjectView();
		this.add(this.lookUpProjectView, "cell 1 0,grow");

		this.lookUpRelationScientistProject = new LookUpRelationScientistProject();
		this.add(this.lookUpRelationScientistProject, "cell 2 0,grow");

		// Add buttons
		this.lookButton = new JButton("Consulta completa");
		this.add(lookButton, "flowx,cell 0 1,alignx left,growy");

		projectButton = new JButton("Consulta proyecto");
		projectButton.setHorizontalAlignment(SwingConstants.RIGHT);
		add(projectButton, "cell 1 1");

		assignedToButton = new JButton("Consulta asignación");
		add(assignedToButton, "cell 2 1");

		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 2 3 1,grow");

		table = new JTable();
		table.setModel(this.currentModel);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);

		scientistButton = new JButton("Consulta cientifico");
		scientistButton.setHorizontalAlignment(SwingConstants.RIGHT);
		add(scientistButton, "cell 0 1");

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
		this.currentModel = this.joinModel;
		this.table.setModel(this.currentModel);
		this.currentModel.addRow(new Object[] { DNI, nom_apels, id_proj, nombre_proy, horas_proy });
	}

	public void setScientistRow(String DNI, String nom_apels) {
		this.currentModel = this.scientistModel;
		this.table.setModel(this.currentModel);
		this.currentModel.addRow(new Object[] { DNI, nom_apels });
	}

	public void setProjectRow(String id_proj, String nombre_proy, String horas_proy) {
		this.currentModel = this.projectModel;
		this.table.setModel(this.currentModel);
		this.currentModel.addRow(new Object[] { id_proj, nombre_proy, horas_proy });
	}

	public void setAssignedToRow(String DNI, String id_proj) {
		this.currentModel = this.assignedModel;
		this.table.setModel(this.currentModel);
		this.currentModel.addRow(new Object[] { DNI, id_proj });
	}

	public void clearRows() {
		this.currentModel.setRowCount(0);
	}

	public JButton getButton() {
		return this.lookButton;
	}

	public JButton getScientistButton() {
		return this.scientistButton;
	}

	public JButton getProjectButton() {
		return this.projectButton;
	}

	public JButton getAssignedToButton() {
		return this.assignedToButton;
	}

}