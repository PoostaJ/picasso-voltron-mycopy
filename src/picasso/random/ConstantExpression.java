package picasso.random;
import java.util.Random;


public class ConstantExpression {
	
	Random Randint = new Random();
	
	//Generate a random RGB value
	double red = Math.random() * 2 - 1;
	double green = Math.random() * 2 - 1;
	double blue = Math.random() * 2 - 1;
	String RGB = "[" + String.valueOf(red) + "," + String.valueOf(green) + "," + String.valueOf(blue) + "]";
	
	//Array of Constants
	String[] constants = {"x" , "y", RGB};
	
	//Randomly choose a constant to generate
	String constant = constants[Randint.nextInt(constants.length)];
	
	RandomExpression expr1;
	
	public ConstantExpression(RandomExpression expr1) {
		this.expr1 = expr1;
	}
	
	public String execute() {
		return "(" + constant + ")";
	}

}

