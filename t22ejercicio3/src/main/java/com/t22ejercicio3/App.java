package com.t22ejercicio3;

import java.sql.Connection;

import controller.InsertController;
import controller.LookUpController;
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
		LookUpController look_up = new LookUpController(my_window, scientist, project, assigned_to, con_mysql);
		DeleteController delete = new DeleteController(my_window, scientist, project, assigned_to, con_mysql);
    }
}
