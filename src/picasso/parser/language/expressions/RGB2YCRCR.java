package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the RGB2YCRCR function in the Picasso language.
 * 
 * @author Jackson Jacobs
 */

public class RGB2YCRCR extends UnaryFunction {

	/**
	 * Create a RgbToYCrCb expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to perform sine on
	 */
	public RGB2YCRCR(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	/**
	 * Evaluates this expression at the given x,y point by evaluating the RGB2YCRCR
	 * of the function's parameter.
	 * 
	 * @return the color that is a result of evaluating the RGB2YCRCR of the expression
	 */
	public RGBColor evaluate(double x, double y) {
		RGBColor result= param.evaluate(x, y);
		double red = result.getRed() * 0.2989 + result.getGreen() * 0.5866 + result.getBlue() * 0.1145;
		double green = result.getRed() * -0.1687 + result.getGreen() * -0.3312 + result.getBlue() * 0.5;
		double blue = result.getRed() * 0.5000 + result.getGreen() * -0.4183 + result.getBlue() * -0.0816;
		return new RGBColor(red, green, blue);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof RGB2YCRCR)) {
			return false;
		}
		RGB2YCRCR r = (RGB2YCRCR) obj;
		return param.equals(r.param);
	}
}
