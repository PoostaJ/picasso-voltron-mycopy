/**
 * 
 */
package picasso.view.commands;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

import picasso.model.Pixmap;
import picasso.parser.language.Assignment;
import picasso.util.Command;

/**
 * Creates a variable reader, which reads and displays a text area to the left of
 * the pixmap
 * 
 * @author Jackson Jacobs
 *
 */

public class VariableReader implements Command<Pixmap> {
	
	private String message;
	private JFrame myFrame;
	private JTextArea myText;

	/**
	 * Variable reader constructor, creates the reader
	 * 
	 * @param frame the frame that the new text area needs to be added to
	 */
	public VariableReader(JFrame frame) {
		myText= new JTextArea();
		myFrame= frame;
	}
	
	/**
	 * Upon hitting the refresh variables button, execute will get the text from 
	 * the temporary file and display it.
	 * 
	 * @param target the pixel map
	 */
	public void execute(Pixmap target) {
		myFrame.getContentPane().remove(myText);
		message= Assignment.getInstance().readFromFile();
		myText=new JTextArea(message);
		getTextArea();
	}

	/**
	 * Overwrites the old text area so there is no overlapping to the west.
	 */
	public void getTextArea() {
		myFrame.getContentPane().add(myText, BorderLayout.WEST);
		myFrame.pack();
	}
}
