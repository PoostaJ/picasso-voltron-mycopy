package picasso.random;

public class RandomExpressionGenerator {
	
	double probConstant;
	double probUnary;
	
	public static void main(String args[]) {
		System.out.println(new RandomExpressionGenerator(0.1,0.3).execute());
	}

	public RandomExpressionGenerator(double probConstant, double probUnary) {	
		this.probConstant = probConstant;
		this.probUnary = probUnary;	
	}
	
	public String execute() {
		
		double randProp = Math.random();
		
				
		if (randProp < probConstant) {
			return new ConstantExpressionGenerator(this).execute();
		}
		
		else if ( randProp < probUnary  ) {
			return new UnaryExpressionGenerator(this).execute();
		}
		
		else {
			return new BinaryExpressionGenerator(this).execute();
		}
		
	}
}
