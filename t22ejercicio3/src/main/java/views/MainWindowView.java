package views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

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
		this.setTitle("Convertidor de monedas");
		this.setBounds(100, 100, 900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fillFrame();

		this.setVisible(true);

	}

	private void fillFrame() {

		this.contentPane = new JPanel();
		this.contentPane.setLayout(null);
		this.contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		// this.setContentPane(this.contentPane);
		
		this.tabbedPane = new JTabbedPane();
		this.tabbedPane.addTab("Introducción de datos", contentPane);
		this.setContentPane(this.tabbedPane);

		this.insertScientistView = new InsertScientistView();
		this.insertScientistView.setBounds(10, 10, 300, 150);
		this.contentPane.add(this.insertScientistView);

		this.insertProjectView = new InsertProjectView();
		this.insertProjectView.setBounds(350, 10, 300, 150);
		this.contentPane.add(this.insertProjectView);

		this.insertRelationScientistProject = new InsertRelationScientistProject();
		this.insertRelationScientistProject.setBounds(700, 10, 300, 150);
		this.contentPane.add(this.insertRelationScientistProject);

		// Add button
		this.insertButton = new JButton("Insert data");
		this.insertButton.setBounds(10, 300, 150, 30);
		this.contentPane.add(insertButton);
		
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
	
}
