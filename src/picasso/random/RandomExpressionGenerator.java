package picasso.random;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.Frame;
import javax.swing.JTextField;

public class RandomExpressionGenerator implements Command<Pixmap> {
	
	double probConstant;
	double probUnary;
	JTextField box;
	
	public static void main(String args[]) {
		//System.out.println(new RandomExpressionGenerator(0.1,0.3).executeS());
	}

	public RandomExpressionGenerator(double probConstant, double probUnary, JTextField box) {	
		this.probConstant = probConstant;
		this.probUnary = probUnary;	
		this.box=box;
	}
	
	public String executeS() {
		
		double randProp = Math.random();
		
				
		if (randProp < probConstant) {
			return new ConstantExpressionGenerator(this).execute();
		}
		
		else if ( randProp < probUnary  ) {
			return new UnaryExpressionGenerator(this).execute();
		}
		
		else {
			return new BinaryExpressionGenerator(this).execute();
		}
		
	}

	@Override
	public void execute(Pixmap target) {
		String expr= this.executeS();
		this.box.setText(expr);
	}
}
