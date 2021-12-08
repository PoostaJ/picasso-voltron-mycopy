package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the wrap function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class Wrap extends UnaryFunction {

	/**
	 * Create a wrap expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to wrap
	 */
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by wrapping the function's parameter.
	 * 
	 * 
	 * @return the color from wrapping the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		
		int redIndex = 0;
		int greenIndex = 1;
		int blueIndex = 2;
		int NumberOfColors = 3; 
		
		double originalRed = result.getRed();
		//System.out.println(originalRed); 
		double originalGreen = result.getGreen();
		double originalBlue = result.getBlue();
		
		double[] colors = new double[NumberOfColors];
		double[] originalColors = {originalRed, originalGreen, originalBlue};
		
		
		int i;
		for (i = 0; i < colors.length; i++) {
			if (originalColors[i] > RGBColor.COLOR_MAX) {
				colors[i] = RGBColor.COLOR_MIN + (originalColors[i] % 2.0);
			}
			
			if (originalColors[i] < RGBColor.COLOR_MIN) {
				colors[i] = RGBColor.COLOR_MAX - (Math.abs(originalColors[i]) % 2.0) ;
			}
			
			else {
				colors[i] = originalColors[i]; 
			}
			
			System.out.println(colors[i]);
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

