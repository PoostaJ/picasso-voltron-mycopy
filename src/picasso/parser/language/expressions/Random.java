package picasso.parser.language.expressions;

/**
 * Represents the Random function in the Picasso language.
 * 
 * @author Dario Fumarola
 * 
 */
public class Random extends MultipleArgumentFunction {
	
	double red = -1 + Math.random() * (1 - (-1));
	double green = -1 + Math.random() * (1 - (-1));
	double blue = -1 + Math.random() * (1 - (-1));

	/**
	 * Implement the Random function on no parameter
	 */
	
	public Random() {

	}

	/**
	 * Evaluates this expression by returning a random rgb
	 * 
	 * @return the color from evaluating the sum of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double unused, double unused2) {



		return new RGBColor(red, green, blue);
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
		if (!(obj instanceof Random)) {
			return false;
		}
		Random f = (Random) obj;
		
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