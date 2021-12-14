/**
 * 
 */
package picasso.view.commands;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import picasso.model.Pixmap;
import picasso.parser.language.Assignment;
import picasso.util.Command;
import picasso.util.NamedCommand;

/**
 * @author Jackson Jacobs
 *
 */
public class VariableReader implements Command<Pixmap> {

	public VariableReader() {
	}
	
	
	public void execute(Pixmap target) {
		String message= Assignment.getInstance().readFromFile();
		JFrame varBox= new JFrame();
		JOptionPane.showMessageDialog(varBox, message);
		varBox.setVisible(true);
	}
}
