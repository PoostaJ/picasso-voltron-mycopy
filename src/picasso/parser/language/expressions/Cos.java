package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Cosine function in the Picasso language.
 * 
 * @author Dario Fumarola
 */

public class Cos extends UnaryFunction {

	/**
	 * Create a Cosine expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to perform cosine on
	 */
	public Cos(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	/**
	 * Evaluates this expression at the given x,y point by evaluating the cosine of
	 * the function's parameter.
	 * 
	 * @return the color that is a result of evaluating the cosine of the expression
	 */
	public RGBColor evaluate(double x, double y) {
		RGBColor result= param.evaluate(x, y);
		double red= Math.cos(result.getRed());
		double green= Math.cos(result.getGreen());
		double blue= Math.cos(result.getBlue());
		return new RGBColor(red, green, blue);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Cos)) {
			return false;
		}
		Cos s = (Cos) obj;
		return param.equals(s.param);
	}
}
