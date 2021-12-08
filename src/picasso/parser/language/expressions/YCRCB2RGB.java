package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;


/**
 * @author Patrick Stoffel
 *
 */
public class YCRCB2RGB extends UnaryFunction {

	/**
	 * Create an YCRCB2RGB expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	public YCRCB2RGB(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the YCRCB2RGB of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the YCRCB2RGB of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.getRed() + result.getBlue() * 1.4022;
		double green = result.getRed() + result.getGreen() * -0.3456 + result.getBlue() * -0.7145;
		double blue = result.getRed() + result.getGreen() * 1.7710;
		return new RGBColor(red, green, blue);
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
		if (!(obj instanceof YCRCB2RGB)) {
			return false;
		}
		YCRCB2RGB f = (YCRCB2RGB) obj;
		return param.equals(f.param);
	}

}
