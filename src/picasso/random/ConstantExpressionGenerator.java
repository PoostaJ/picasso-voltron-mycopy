package picasso.random;
import java.util.Random;


public class ConstantExpressionGenerator {
	
	Random Randint = new Random();
	
	//Generate a random RGB value
	double red = Math.random() * 2 - 1;
	double green = Math.random() * 2 - 1;
	double blue = Math.random() * 2 - 1;
	String RGB = "[" + String.valueOf(red).substring(0, 5) + "," + String.valueOf(green).substring(0, 5) + "," + String.valueOf(blue).substring(0, 5) + "]";
	
	//Array of Constants
	String[] constants = {"x" , "y", RGB};
	
	//Randomly choose a constant to generate
	String constant = constants[Randint.nextInt(constants.length)];
	
	RandomExpressionGenerator expr1;
	
	public ConstantExpressionGenerator(RandomExpressionGenerator expr1) {
		this.expr1 = expr1;
	}
	
	public String execute() {
		return "(" + constant + ")";
	}

}

