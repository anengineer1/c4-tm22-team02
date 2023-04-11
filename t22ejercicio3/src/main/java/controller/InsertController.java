package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.AssignedTo;
import models.Project;
import models.Scientist;
import views.MainWindowView;

public class InsertController implements ActionListener {

	private MainWindowView mainWindowView;
	private Scientist scientist;
	private Project project;
	private AssignedTo assignedTo;

	public InsertController(MainWindowView main_window, Scientist scientist_model, Project project_model,
			AssignedTo assigned_to_model) {
		this.mainWindowView = main_window;
		this.scientist = scientist_model;
		this.project = project_model;
		this.assignedTo = assigned_to_model;
		
		this.mainWindowView.getInsertButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Get all the info from the view
		this.infoFromViewToModels();
		
		// TODO: insert to database

	}
	
	private void infoFromViewToModels() {
		this.scientist.setDNI(this.mainWindowView.getInsertScientistView().getScientistDNI());
		this.scientist.setNomApels(this.mainWindowView.getInsertScientistView().getNomApels());
		
		this.project.setIdProject(this.mainWindowView.getInsertProjectView().getIdProject());
		this.project.setName(this.mainWindowView.getInsertProjectView().getProjectName());
		this.project.setHours(this.mainWindowView.getInsertProjectView().getHours());
		
		this.assignedTo.setDNI(this.mainWindowView.getInsertRelationScientistProject().getScientistDNI());
		this.assignedTo.setIdProject(this.mainWindowView.getInsertRelationScientistProject().getProjectId());
	}

}
