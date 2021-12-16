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
 * @author Jackson Jacobs
 *
 */
public class VariableReader implements Command<Pixmap> {
	
	private String message;
	private JFrame myFrame;
	private JTextArea myText;

	public VariableReader(JFrame frame) {
		myText= new JTextArea();
		myFrame= frame;
	}
	
	
	public void execute(Pixmap target) {
		myFrame.getContentPane().remove(myText);
		message= Assignment.getInstance().readFromFile();
		myText=new JTextArea(message);
		getTextArea();
	}

	public void getTextArea() {
		myFrame.getContentPane().add(myText, BorderLayout.WEST);
		myFrame.pack();
	}
}
