package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Sine function in the Picasso language.
 * 
 * @author Jackson Jacobs
 */

public class Sin extends UnaryFunction {

	/**
	 * Create a sine expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to perform sine on
	 */
	public Sin(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	/**
	 * Evaluates this expression at the given x,y point by evaluating the sine of
	 * the function's parameter.
	 * 
	 * @return the color that is a result of evaluating the sine of the expression
	 */
	public RGBColor evaluate(double x, double y) {
		RGBColor result= param.evaluate(x, y);
		double red= Math.sin(result.getRed());
		double green= Math.sin(result.getGreen());
		double blue= Math.sin(result.getBlue());
		return new RGBColor(red, green, blue);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Sin)) {
			return false;
		}
		Sin s = (Sin) obj;
		return param.equals(s.param);
	}
}
