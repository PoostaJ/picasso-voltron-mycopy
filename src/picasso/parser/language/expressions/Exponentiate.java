package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

import java.lang.Math;


/**
 * Represents the ^ operation in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Dario Fumarola
 * 
 */
public class Exponentiate extends BinaryFunction {

	/**
	 * Implement the ^ operation on the left and right expressions
	 * 
	 * @param left      left expression
	 * @param right     right expression
	 */
	public Exponentiate(ExpressionTreeNode left, ExpressionTreeNode right) {
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
		if (!(obj instanceof Exponentiate)) {
			return false;
		}
		Exponentiate f = (Exponentiate) obj;
		
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
	 * Evaluates this expression at the given x,y point by evaluating the exponent of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the exponent product of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor leftColor = left.evaluate(x, y);
		RGBColor rightColor = right.evaluate(x, y);
		double red = Math.pow(leftColor.getRed(), rightColor.getRed());
		double green = Math.pow(leftColor.getGreen(), rightColor.getGreen());
		double blue = Math.pow(leftColor.getBlue(), rightColor.getBlue());
		
		return new RGBColor(red, green, blue);
	}

}
