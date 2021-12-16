/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.model.ImprovedNoise;

/**
 * Represents the PerlinColor function.
 * 
 * @author Patrick Stoffel
 *
 */
public class PerlinColor extends MultipleArgumentFunction {

	/**
	 * Implements the PerlinColor function on the left and right expressions.
	 * 
	 * @param Left		Left expression
	 * @param Right		Right expression
	 */
	public PerlinColor(ExpressionTreeNode expr1, ExpressionTreeNode expr2) {
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
		if (!(obj instanceof PerlinColor)) {
			return false;
		}
		PerlinColor f = (PerlinColor) obj;
		
		if (expr1.equals(f.expr1) && expr2.equals(f.expr2)) {
			return true;
		}
		
		else {
			return false;
		}
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the PerlinColor of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the PerlinColor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = expr1.evaluate(x, y);
		RGBColor right = expr2.evaluate(x, y);
		double red = ImprovedNoise.noise(left.getRed() + 0.3, right.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(left.getBlue() + 0.1, right.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(left.getGreen() - 0.8, right.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
	}

}
