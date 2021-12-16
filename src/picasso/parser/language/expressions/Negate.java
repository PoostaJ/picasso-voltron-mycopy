package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments.
 * 
 * @author Patrick Stoffel 
 *
 */

public class Negate extends ExpressionTreeNode {

	ExpressionTreeNode param;
	
	/**
	 * Create a negation expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to negate
	 */
	public Negate(ExpressionTreeNode param) {
		this.param = param;
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the negation of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the negation of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		return new RGBColor(-1 * result.getRed(), -1*result.getGreen(), -1*result.getBlue());
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
		if (!(obj instanceof Negate)) {
			return false;
		}
		Negate f = (Negate) obj;
		return param.equals(f.param);
	}
}
