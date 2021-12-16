package picasso.random;

import picasso.model.Pixmap;

import picasso.util.Command;
import picasso.view.Frame;
import javax.swing.JTextField;

/**
 * Generate a Random Mathematical Expression
 * 
 * @author Dan Nguyen 
 * 
 */

public class RandomExpressionGenerator implements Command<Pixmap> {
	
	double probConstant;
	double probUnary;
	JTextField box;
	final static double DEFAULT_CONSTANT = 0.1;
	final static double DEFAULT_UNARY = 0.3;
	

	public RandomExpressionGenerator(double probConstant, double probUnary, JTextField box) {	
		this.probConstant = probConstant;
		this.probUnary = probUnary;	
		this.box=box;
	}
	
	public String generate() {
		
		double randProp = Math.random();
		
				
		if (randProp < probConstant) {
			return new ConstantExpressionGenerator(this).generate();
		}
		
		else if ( randProp < probUnary  ) {
			return new UnaryExpressionGenerator(this).generate();
		}
		
		else {
			return new BinaryExpressionGenerator(this).generate();
		}
		
	}

	@Override
	public void execute(Pixmap target) {
		String expr= this.generate();
		this.box.setText(expr);
		this.probConstant = DEFAULT_CONSTANT;
		this.probUnary = DEFAULT_UNARY;	
	}
}
