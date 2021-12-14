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
		// add commands to test here
		commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add(myField);
		commands.add("Evaluater", new ThreadedCommand<Pixmap>(canvas, new Evaluater(myField)));
		commands.add("Save", new Writer());	
		commands.add(new NamedCommand<Pixmap>("Variables", new VariableReader()));
		/**
		 * Cant add a button that pulls up the current variable names. It has to be
		 * <Pixmap>, but the command should not really operate on the pixmap,
		 * so I am confused on what to do. VariableReader wont work, but I dont know
		 * how else to read from a file and have the reading tied to a button press
		 */
		
		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		pack();
	}
	
	public static void drawException(String errorText) {
		JFrame errorBox= new JFrame();
		JOptionPane.showMessageDialog(errorBox, errorText);
		errorBox.setVisible(true);
	}
	
	public static void drawVariableBox(String fileText) {
		JFrame varBox= new JFrame();
		JOptionPane.showMessageDialog(varBox, fileText);
		varBox.setVisible(true);
	}
}
