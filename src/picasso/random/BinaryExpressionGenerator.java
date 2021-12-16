package picasso.random;

import java.util.Random;

public class BinaryExpressionGenerator {
	
	Random Randint = new Random();
	String operator;
	
	String[] BinaryOperators = {"+", "-", "*", "^"};
	String binaryOperator = BinaryOperators[Randint.nextInt(BinaryOperators.length)]; 
	
	RandomExpressionGenerator expr1;
	
	public BinaryExpressionGenerator(RandomExpressionGenerator expr1) {
		this.expr1 = expr1;
		this.expr1.probConstant += 0.1;
		this.expr1.probUnary += 0.1;
	}
	
	public String execute() {
		
		return "(" + expr1.execute() + ")"+ binaryOperator + "(" + expr1.execute() + ")";
		
	}
	
}
