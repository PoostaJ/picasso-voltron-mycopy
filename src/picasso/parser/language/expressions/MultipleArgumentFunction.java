package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments.
 * 
 * @author Dan Nguyen
 *
 */
public abstract class MultipleArgumentFunction extends ExpressionTreeNode {
	
	public static final double COLOR_MIN = -1;
	public static final double COLOR_MAX = 1;

	ExpressionTreeNode expr1;
	ExpressionTreeNode expr2;

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public MultipleArgumentFunction(ExpressionTreeNode expr1, ExpressionTreeNode expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	public MultipleArgumentFunction() {

	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".")) + "(" + expr1 + "," + expr2 + ")";
	}
	
	public abstract boolean equals(Object obj);

}
