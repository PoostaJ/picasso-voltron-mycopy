/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.model.ImprovedNoise;

/**
 * Represents the PerlinBW function.
 * 
 * @author Dario Fumarola
 *
 */
public class PerlinBW extends MultipleArgumentFunction {

	/**
	 * Implements the PerlinBW function on the left and right expressions.
	 * 
	 * @param Left		Left expression
	 * @param Right		Right expression
	 */
	public PerlinBW(ExpressionTreeNode expr1, ExpressionTreeNode expr2) {
		super(expr1, expr2);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PerlinBW)) {
			return false;
		}
		PerlinBW f = (PerlinBW) obj;
		
		if (expr1.equals(f.expr1) && expr2.equals(f.expr2)) {
			return true;
		}
		
		else {
			return false;
		}
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the PerlinBW of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the PerlinBW of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = expr1.evaluate(x, y);
		RGBColor right = expr2.evaluate(x, y);
		double grey = ImprovedNoise.noise(left.getRed() + right.getRed(), left.getGreen() + right.getGreen(), left.getBlue() + right.getBlue());
		return new RGBColor(grey, grey, grey);
		}
}


