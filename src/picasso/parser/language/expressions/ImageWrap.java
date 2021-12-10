package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;
import java.awt.Color;
import picasso.model.Pixmap;
import java.awt.Dimension;
import picasso.view.commands.Evaluater;

/**
 * Represents the imageWrap function in the Picasso language.
 * 
 * @author 
 * 
 */
public class ImageWrap extends MultipleArgumentFunction {
	
	Pixmap img = null; 
	
	/**
	 * Implement the + operation on the left and right expressions
	 * 
	 * @param left      left expression
	 * @param right     right expression
	 */
	
	public ImageWrap(String filename, ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		img.read(filename);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the sum of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the sum of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		
		Dimension size = img.getSize();
		
		for (int imageY = 0; imageY < size.height; imageY++) {
			double evalY = wrap(imageY);
			for (int imageX = 0; imageX < size.width; imageX++) {
				double evalX = wrap(imageX);
				Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
				target.setColor(imageX, imageY, pixelColor);
			}
		}
		
		RGBColor leftColor = expr1.evaluate(x, y);
		RGBColor rightColor = expr2.evaluate(x, y);
		double red = leftColor.getRed() + rightColor.getRed();
		double green = leftColor.getGreen() + rightColor.getGreen();
		double blue = leftColor.getBlue() + rightColor.getBlue();

		return new RGBColor(red, green, blue);
	}
	
	public double wrap(double value) {
			
			if (value > RGBColor.COLOR_MAX) {
				return (RGBColor.COLOR_MIN + ((value -1) % 2.0));
			}
			
			if (value < RGBColor.COLOR_MIN) {
				return (RGBColor.COLOR_MAX - (Math.abs(value-1) % 2.0)) ;
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