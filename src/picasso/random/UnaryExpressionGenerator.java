package picasso.random;

import java.util.Random;

public class UnaryExpressionGenerator {
	
	Random Randint = new Random();
	
	
	String[] UnaryFunctions = {"floor", "ceil", "sin", "cos", "tan", "atan", "RGB2YCRCR", "YCRCB2RGB", "log"};
	
	String unaryFunction = UnaryFunctions[Randint.nextInt(UnaryFunctions.length)]; 
	
	RandomExpressionGenerator expr1;
	
	public UnaryExpressionGenerator(RandomExpressionGenerator expr1) {
		this.expr1 = expr1;
		this.expr1.probConstant += 0.1;
		this.expr1.probUnary += 0.1;

	}
	
	public String generate() {	
		
		return unaryFunction + "(" +   expr1.generate()  + ")";
		
	}
	
}
