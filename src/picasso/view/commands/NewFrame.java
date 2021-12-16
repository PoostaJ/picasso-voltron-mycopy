package picasso.view.commands;


import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.Frame;
import picasso.Main;
import javax.swing.JFrame;

/**
 * Handles creating new frames when the New Window button is pressed.
 * 
 * @author Jackson Jacobs
 *
 */

@SuppressWarnings("serial")
public class NewFrame extends JFrame implements Command<Pixmap> {

	/**
	 * Executes, creating a new frame set to close only that window upon exit.
	 * 
	 * @param target the pixel map
	 */
	public void execute(Pixmap target) {
		Frame NewFrame= new Frame(Main.SIZE);
		NewFrame.setTitle("Picasso- Voltron");
		NewFrame.setVisible(true);
		NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

}
