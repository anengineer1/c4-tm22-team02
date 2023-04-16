package com.t22ejercicio3;

import java.sql.Connection;

import controller.InsertController;
import controller.LookUpControllerAssignedTo;
import controller.LookUpControllerJoin;
import controller.LookUpControllerProject;
import controller.LookUpControllerScientist;
import controller.UpdateController;
import controller.DeleteController;
import views.MainWindowView;
import models.Scientist;
import models.Project;
import models.AssignedTo;
import utils.MySQLConnectionHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		MainWindowView my_window = new MainWindowView();
		Scientist scientist = new Scientist();
		Project project = new Project();
		AssignedTo assigned_to = new AssignedTo();
		Connection con_mysql = MySQLConnectionHandler.initConnection("localhost", "10023", "remote", "cuser90r");
		InsertController contrler = new InsertController(my_window, scientist, project, assigned_to, con_mysql);
		LookUpControllerJoin look_up = new LookUpControllerJoin(my_window, scientist, project, assigned_to, con_mysql);
		LookUpControllerScientist look_up_scientist = new LookUpControllerScientist(my_window, scientist, project, assigned_to, con_mysql);
		LookUpControllerProject look_up_project = new LookUpControllerProject(my_window, scientist, project, assigned_to, con_mysql);
		LookUpControllerAssignedTo assigned_to_project = new LookUpControllerAssignedTo(my_window, scientist, project, assigned_to, con_mysql);
		DeleteController delete = new DeleteController(my_window, scientist, project, assigned_to, con_mysql);
		UpdateController update = new UpdateController(my_window, scientist, project, assigned_to, con_mysql);
    }
}
