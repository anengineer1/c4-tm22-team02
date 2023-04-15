package views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class MainWindowView extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JButton insertButton;

	private InsertScientistView insertScientistView;
	private InsertProjectView insertProjectView;
	private InsertRelationScientistProject insertRelationScientistProject;
	private LookUpView lookUpView;
	private DeleteView deleteView;

	public MainWindowView() {
		initialize();

	}

	private void initialize() {
		this.setTitle("Base de datos cientificos");
		this.setBounds(100, 100, 1025, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fillFrame();

		this.setVisible(true);

	}

	private void fillFrame() {

		this.contentPane = new JPanel();
		this.contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		// this.setContentPane(this.contentPane);

		this.tabbedPane = new JTabbedPane();
		this.tabbedPane.addTab("Introducción de datos", contentPane);
		this.setContentPane(this.tabbedPane);
		contentPane.setLayout(new MigLayout("", "[300px][300px][300px]", "[150px][30px][]"));

		this.insertScientistView = new InsertScientistView();
		this.contentPane.add(this.insertScientistView, "cell 0 0,grow");

		this.insertProjectView = new InsertProjectView();
		this.contentPane.add(this.insertProjectView, "cell 1 0,grow");

		this.insertRelationScientistProject = new InsertRelationScientistProject();
		this.contentPane.add(this.insertRelationScientistProject, "cell 2 0,grow");

		// Add button
		this.insertButton = new JButton("Insert data");
		this.contentPane.add(insertButton, "cell 0 1,alignx left,growy");

		// Add look up view
		this.lookUpView = new LookUpView();
		this.lookUpView.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.tabbedPane.addTab("Visualización", this.lookUpView);
		
		// Add delete view
		this.deleteView = new DeleteView();
		this.deleteView.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.tabbedPane.addTab("Borrado", this.deleteView);
	}

	public InsertScientistView getInsertScientistView() {
		return insertScientistView;
	}

	public InsertProjectView getInsertProjectView() {
		return insertProjectView;
	}

	public InsertRelationScientistProject getInsertRelationScientistProject() {
		return insertRelationScientistProject;
	}
	
	public void setRow(String DNI, String nom_apels, String id_proj, String nombre_proy, String horas_proy) {
		this.lookUpView.setRow(DNI, nom_apels, id_proj, nombre_proy, horas_proy);
	}
	
	public void clearRows() {
		this.lookUpView.clearRows();
	}

	public JButton getInsertButton() {
		return this.insertButton;
	}
	
	public String getLookUpScientistDNI() {
		return this.lookUpView.getScientistDNI();
	}

	public String getLookUpScientistNomApels() {
		return this.lookUpView.getScientistNomApels();
	}

	public String getLookUpProjectId() {
		return this.lookUpView.getIdProject();
	}
	
	public String getLookUpProjectName() {
		return this.lookUpView.getProjectName();
	}
	
	public String getLookUpProjectHours() {
		return this.lookUpView.getProjectHours();
	}

	public JButton getLookUpButton() {
		return this.lookUpView.getButton();
	}
	
	public String getDeleteScientistDNI() {
		return this.deleteView.getScientistDNI();
	}

	public String getDeleteProjectId() {
		return this.deleteView.getIdProject();
	}
	
	public String getDeleteAssginedToDNI() {
		return this.deleteView.getAssignedToDNI();
	}

	public String getDeleteAssignedToId() {
		return this.deleteView.getAssignedToProjectId();
	}
	
	public JButton getDeleteButton() {
		return this.deleteView.getButton();
	}
}
