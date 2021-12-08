package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the log function in the Picasso language.
 * 
 * @author Dan Nguyen
 * 
 */
public class Log extends UnaryFunction {

	/**
	 * Create a log expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */

	public Log(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates the log value of what is passed in
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		
		//double red = result.getRed();
		//double green = result.getGreen();
		//double blue = result.getBlue();
	
		int redIndex = 0;
		int greenIndex = 1;
		int blueIndex = 2;
		int NumberOfColors = 3;
		
		double originalRed = result.getRed();
		double originalGreen = result.getGreen();
		double originalBlue = result.getBlue();
		
		double[] colors = new double[NumberOfColors];
		double[] originalColors = {originalRed, originalGreen, originalBlue};
		
		int i;
	
		for (i = 0; i < colors.length; i++) {
			if (originalColors[i] == 0.0) {
				colors[i] = 0.0;
			}
			
			else {
				colors[i] = Math.log(Math.abs(originalColors[i]));
			}
		}
		
		double red = colors[redIndex];
		double green = colors[greenIndex];
		double blue = colors[blueIndex];

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
