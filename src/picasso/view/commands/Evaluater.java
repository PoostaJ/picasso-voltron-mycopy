package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.Command;
import picasso.view.Frame;
import picasso.view.ButtonPanel;
import picasso.parser.language.CharConstants;
import picasso.parser.ParseException;


/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluater implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	private JTextField box;
	
	public Evaluater(JTextField box) {
		this.box= box;
	}
	/**
	 * Evaluate an expression for each point in the image.
	 */
	public void execute(Pixmap target) {
		String input= box.getText();
		ExpressionTreeNode expr;
		input= Assignment.getInstance().check(input);
		
		/**
		//TODO: refactor this so it is all handled in Assignment.java
		if (Assignment.getInstance().get(input)!=null) {
			input=Assignment.getInstance().get(input);
		}
		else if (input.contains(Character.toString(CharConstants.EQUAL))) {
			Assignment.getInstance().assign(input);
			String[] arr=input.split(Character.toString(CharConstants.EQUAL));
			input=arr[1];
		}
		*/
		
		try {
			expr = createExpression(input);
		}
		catch (ParseException e) {
			Frame.drawException(e.getMessage());
			return;
		}


		// evaluate it for each pixel
		Dimension size = target.getSize();
		for (int imageY = 0; imageY < size.height; imageY++) {
			double evalY = imageToDomainScale(imageY, size.height);
			for (int imageX = 0; imageX < size.width; imageX++) {
				double evalX = imageToDomainScale(imageX, size.width);
				Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
				target.setColor(imageX, imageY, pixelColor);
			}
		}
	}

	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}

	/**
	 * 
	 * A place holder for a more interesting way to build the expression.
	 */
	private ExpressionTreeNode createExpression(String ourInput) {
		// Note, when you're testing, you can use the ExpressionTreeGenerator to
		// generate expression trees from strings, or you can create expression
		// objects directly (as in the commented statement below).

		//String test = "floor(y)";
		//String test = "x + y";

		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		
		return expTreeGen.makeExpression(ourInput);
		

		// return new Multiply( new X(), new Y() );
	}

}
