package picasso.view.commands;


import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.Frame;
import picasso.Main;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NewFrame extends JFrame implements Command<Pixmap> {

	public NewFrame() {
	}
	public void execute(Pixmap target) {
		Frame NewFrame= new Frame(Main.SIZE);
		NewFrame.setTitle("Picasso- Voltron");
		NewFrame.setVisible(true);
		NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

}
