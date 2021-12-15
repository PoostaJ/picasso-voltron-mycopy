/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the % operation in the Picasso language.
 * 
 * @author Patrick Stoffel
 * @author Dan Nguyen
 *
 */
public class Mod extends BinaryFunction {

	/**
	 * Implement the % operation on the left and right expressions
	 * 
	 * @param left      left expression
	 * @param right     right expression
	 */
	public Mod(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
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
		if (!(obj instanceof Mod)) {
			return false;
		}
		Mod f = (Mod) obj;
		
		if (left.equals(f.left) && right.equals(f.right)) {
			return true;
		}
		
		else {
			return false;
		}
	}

	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the mod of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the mod of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		
		int redIndex = 0;
		int greenIndex = 1;
		int blueIndex = 2;
		int NumberOfColors = 3;
		
		RGBColor leftColor = left.evaluate(x, y);
		RGBColor rightColor = right.evaluate(x, y);
		
		double rightRed = rightColor.getRed();
		double rightGreen = rightColor.getGreen();
		double rightBlue = rightColor.getBlue();
		
		double leftRed = leftColor.getRed();
		double leftGreen = leftColor.getGreen();
		double leftBlue = leftColor.getBlue();
		

		double[] colors = new double[NumberOfColors];
		double[] rightColors = {rightRed, rightGreen, rightBlue};
		double[] leftColors = {leftRed, leftGreen, leftBlue};
		
		int i;
		for (i = 0; i < colors.length; i++) {
			if (rightColors[i] == 0) {
				colors[i] = 0;
			}
			
			else {
				colors[i] = leftColors[i] % rightColors[i];
			}
		}
		
		double red = colors[redIndex];
		double green = colors[greenIndex];
		double blue = colors[blueIndex];

		return new RGBColor(red, green, blue);
		
	}

}
