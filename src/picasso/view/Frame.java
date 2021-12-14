package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

import picasso.model.Pixmap;
import picasso.parser.language.Assignment;
import picasso.util.NamedCommand;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;
import java.awt.event.*;


/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	protected JTextField myField;
	private ButtonPanel commands;

	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
    
		myField= new JTextField(20);
		VariableReader r= new VariableReader(this);
		// add commands to test here
		commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add(myField);
		commands.add("Evaluater", new ThreadedCommand<Pixmap>(canvas, new Evaluater(myField)));
		commands.add("Save", new Writer());	
		commands.add(new NamedCommand<Pixmap>("Refresh Variables", r));

		
		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		//getContentPane().add(r, BorderLayout.WEST);
		pack();
	}
	
	public static void drawException(String errorText) {
		JFrame errorBox= new JFrame();
		JOptionPane.showMessageDialog(errorBox, errorText);
		errorBox.setVisible(true);
	}
}
