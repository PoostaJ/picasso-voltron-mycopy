package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments.
 * 
 * @author Dan Nguyen
 *
 */
public abstract class BinaryFunction extends ExpressionTreeNode {
	
	public static final double COLOR_MIN = -1;
	public static final double COLOR_MAX = 1;

	ExpressionTreeNode left;
	ExpressionTreeNode right;

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public BinaryFunction(ExpressionTreeNode left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right;
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
		return classname.substring(classname.lastIndexOf(".")) + "(" + left + "," + right + ")";
	}
	
	public abstract boolean equals(Object obj);

}
