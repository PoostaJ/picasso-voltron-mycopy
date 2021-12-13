/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the % operation in the Picasso language.
 * 
 * @author Patrick Stoffel
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
		
		if (left.equals(f.right) && right.equals(f.left)) {
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
		RGBColor leftColor = left.evaluate(x, y);
		RGBColor rightColor = right.evaluate(x, y);
		double red = leftColor.getRed() % rightColor.getRed();
		double green = leftColor.getGreen() % rightColor.getGreen();
		double blue = leftColor.getBlue() % rightColor.getBlue();
		
		return new RGBColor(red, green, blue);
	}

}
