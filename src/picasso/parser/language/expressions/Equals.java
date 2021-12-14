/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Jackson Jacobs
 *
 */
public class Equals extends BinaryFunction {

	/**
	 * @param left
	 * @param right
	 */
	public Equals(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		return null;
	}

}
