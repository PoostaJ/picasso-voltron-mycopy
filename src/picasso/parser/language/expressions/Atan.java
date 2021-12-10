package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Arctangnet function in the Picasso language.
 * 
 * @author Jackson Jacobs
 */

public class Atan extends UnaryFunction {

	/**
	 * Create an arctangent expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to perform arctangent on
	 */
	public Atan(ExpressionTreeNode param) {
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
		double red= Math.atan(result.getRed());
		double green= Math.atan(result.getGreen());
		double blue= Math.atan(result.getBlue());
		return new RGBColor(red, green, blue);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Atan)) {
			return false;
		}
		Atan a = (Atan) obj;
		return param.equals(a.param);
	}
}