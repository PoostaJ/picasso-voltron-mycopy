package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

import picasso.model.Pixmap;
import picasso.parser.language.Assignment;
import picasso.random.RandomExpressionGenerator;
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
	private ButtonPanel commandsBottom;

	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
    
		
		myField= new JTextField(20);
		VariableReader r= new VariableReader(this);
		RandomExpressionGenerator ranExpr= new RandomExpressionGenerator(0.1,0.3, myField);
    
		// add commands to test here
		commands = new ButtonPanel(canvas);
		commandsBottom= new ButtonPanel(canvas);
		commandsBottom.add("Open", new Reader());
		commands.add(myField);
		commands.add("Evaluater", new ThreadedCommand<Pixmap>(canvas, new Evaluater(myField)));
		commandsBottom.add("Save", new Writer());	
		commands.add(new NamedCommand<Pixmap>("Refresh Variables", r));		
		commands.add(new NamedCommand<Pixmap>("Random!", ranExpr));
		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(commandsBottom, BorderLayout.SOUTH);

		pack();
	}
	
	public static void drawException(String errorText) {
		JFrame errorBox= new JFrame();
		JOptionPane.showMessageDialog(errorBox, errorText);
		errorBox.setVisible(true);
	}
}
