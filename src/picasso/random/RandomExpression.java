package picasso.random;

public class RandomExpression {
	
	double probConstant;
	double probUnary;
	
	
	String[] operators = {"+" , "-", "*", "/"};
	String[] functions = {"floor", "ceil", "sin", "cos"};
	
	public static void main(String args[]) {
		System.out.println(new RandomExpression(0.1,0.3).execute());
	}

	public RandomExpression(double probConstant, double probUnary) {	
		this.probConstant = probConstant;
		this.probUnary = probUnary;	
	}
	
	public String execute() {
		
		double randProp = Math.random();
		
				
		if (randProp < probConstant) {
			return new ConstantExpression(this).execute();
		}
		
		else if ( randProp < probUnary  ) {
			return new UnaryFunction(this).execute();
		}
		
		else {
			return new BinaryOperator(this).execute();
		}
		
	}
}
