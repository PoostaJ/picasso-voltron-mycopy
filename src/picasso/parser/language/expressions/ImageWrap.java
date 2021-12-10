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

		
		//int evalY = img.getSize().height;
		//int evalX = img.getSize().width;
		x = 2*x;
		double evalY= wrap(y);
		double evalX= wrap(x);
		System.out.println("Expected: -.8  Actual: " + evalX);
		System.out.println("Expected: 79" + " Actual: " + widthToInt(evalX));
		RGBColor newRGB= new RGBColor(img.getColor(widthToInt(evalX), heightToInt(evalY)));
		//System.out.println("Expected: "+ x);
		//System.out.println("Actual: "+ evalX);
		return newRGB;
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

	
	public int heightToInt(double value) {
		double range = 2;
		return (int) ((value+1) /2 * img.getSize().height);
	}
	
	public int widthToInt(double value) {
		double range = 2;
		return (int) ((value+1) /2 * img.getSize().width);
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