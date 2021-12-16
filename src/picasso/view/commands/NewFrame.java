package picasso.view.commands;


import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.Frame;
import picasso.Main;

public class NewFrame implements Command<Pixmap> {

	public NewFrame() {
	}
	public void execute(Pixmap target) {
		Frame NewFrame= new Frame(Main.SIZE);
		NewFrame.setTitle("Picasso- Voltron");
		NewFrame.setVisible(true);
		}

}
