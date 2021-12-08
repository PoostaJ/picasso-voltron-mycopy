package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the floor function in the Picasso language.
 * 
 * @author Dan Nguyen
 * 
 */
public class Log extends UnaryFunction {

	/**
	 * Create a floor expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */

	public Log(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the floor of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();
		
		double [] colors = {red, green, blue};
		
		int i;
		for (i = 0; i < colors.length; i++) {
			if (colors[i] == 0) {
				colors[i] = 0;
			}
			
			else {
				colors[i] = Math.log(Math.abs(colors[i]));
			}
		}
		
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
		if (!(obj instanceof Floor)) {
			return false;
		}
		Floor f = (Floor) obj;
		return param.equals(f.param);
	}

}