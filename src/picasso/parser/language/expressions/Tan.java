package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

import java.lang.Math;

/**
 * Represents the Tan function in the Picasso language.
 * 
 * @author Dario Fumarola
 * 
 */
public class Tan extends UnaryFunction {

	/**
	 * Create a tan expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to tan
	 */

	public Tan(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates the tan value of what is passed in
	 * 
	 * @return the color from evaluating the tan of the expression's parameter
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
			if (originalColors[i] % ((Math.PI/2) + Math.PI) == 0) {
				colors[i] = colors[i];    // Placeholder
			}
			
			else {
				colors[i] = Math.tan(originalColors[i]);
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
		if (!(obj instanceof Tan)) {
			return false;
		}
		Tan f = (Tan) obj;
		return param.equals(f.param);
	}

}
