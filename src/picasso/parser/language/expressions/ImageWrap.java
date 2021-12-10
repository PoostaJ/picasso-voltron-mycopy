package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;
import java.awt.Color;
import picasso.model.Pixmap;
import java.awt.Dimension;
import picasso.view.commands.Evaluater;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the imageWrap function in the Picasso language.
 * 
 * @author 
 * 
 */
public class ImageWrap extends MultipleArgumentFunction {
	
	Pixmap img;
	
	/**
	 * Implement the + operation on the left and right expressions
	 * 
	 * @param left      left expression
	 * @param right     right expression
	 */
	
	public ImageWrap(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		img= new Pixmap("images/vortex.jpg");
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the sum of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the sum of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {

		int imageY= (int) Math.round(y);
		int imageX= (int) Math.round(x);
		
		int evalY= wrapHeight(imageY);
		int evalX= wrapHeight(imageX);
		
		RGBColor newRGB= new RGBColor(img.getColor(evalX, evalY));
		return newRGB;
	}

	public int wrapHeight(int value) {
			
			if (value > img.getSize().height) {
				return Math.round(0 + (value % img.getSize().height));
			}
			
			if (value < 0) {
				return Math.round(img.getSize().height - (Math.abs(value) % img.getSize().height)) ;
			}
			
			else {
				return value;
			}
	}
	
	public int wrapWidth(int value) {
		
		
		if (value > img.getSize().width) {
			return Math.round(0 + (value % img.getSize().width));
		}
		
		if (value < 0) {
			return Math.round(img.getSize().width - (Math.abs(value) % img.getSize().width)) ;
		}
		
		else {
			return value;
		}
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
		if (!(obj instanceof Plus)) {
			return false;
		}
		ImageWrap f = (ImageWrap) obj;
		
		if (expr1.equals(f.expr1) && expr2.equals(f.expr2)) {
			return true;
		}
		
		if (expr1.equals(f.expr2) && expr2.equals(f.expr1)) {
			return true;
		}
		
		else {
			return false;
		}
		
		
	}

}