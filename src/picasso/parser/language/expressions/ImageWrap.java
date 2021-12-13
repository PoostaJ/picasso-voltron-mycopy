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
 * @author Dan Nguyen
 * 
 */
public class ImageWrap extends MultipleArgumentFunction {
	
	Pixmap img;
	
	/**
	 * Implement the imageWrap function on the left and right expressions
	 * 
	 * @param left      left expression
	 * @param right     right expression
	 */
	
	public ImageWrap(String filename, ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		img= new Pixmap("images/" + filename);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the sum of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the sum of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor leftColor=expr1.evaluate(x, y);
		RGBColor rightColor=expr2.evaluate(x, y);
		double evalY= wrap(leftColor.getRed());
		double evalX= wrap(rightColor.getRed());

		RGBColor newRGB= new RGBColor(img.getColor(widthToInt(evalX), heightToInt(evalY)));
		return newRGB;
	}

	public double wrap(double value) {

		if (value > RGBColor.COLOR_MAX) {
			return (RGBColor.COLOR_MIN + ((value - RGBColor.COLOR_MAX) % RGBColor.RANGE));
		}
		
		if (value < RGBColor.COLOR_MIN) {
			return (RGBColor.COLOR_MAX - (Math.abs(value- RGBColor.COLOR_MAX) % RGBColor.RANGE)) ;
		}
		
		else {
			return value;
		}
	}

	
	public int heightToInt(double value) {
		return (int) ((value - RGBColor.COLOR_MIN) /RGBColor.RANGE * img.getSize().height);
	}
	
	public int widthToInt(double value) {
		return (int) ((value - RGBColor.COLOR_MIN) /RGBColor.RANGE * img.getSize().width);
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