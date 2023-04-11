package com.t22ejercicio3;

import controller.InsertController;
import views.MainWindowView;
import models.Scientist;
import models.Project;
import models.AssignedTo;

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
		InsertController contrler = new InsertController(my_window, scientist, project, assigned_to);
    }
}
