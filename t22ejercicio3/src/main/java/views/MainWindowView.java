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

	public JButton getInsertButton() {
		return this.insertButton;
	}
	
	public InsertScientistView getLookUpScientistView() {
		return insertScientistView;
	}

	public InsertProjectView getLookUpProjectView() {
		return insertProjectView;
	}

	public InsertRelationScientistProject getLookUpScientistProject() {
		return insertRelationScientistProject;
	}

	public JButton getLookUpButton() {
		return this.getLookUpView().getButton();
	}
	
	public LookUpView getLookUpView() {
		return this.lookUpView;
	}
}
