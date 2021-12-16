package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 * 
 */
public class ParsedExpressionTreeTests {


	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
	}
	
	
	@Test
	public void PlusExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");

		assertEquals(new Plus(new X(), new Y()), e);
		
		// no spaces!
		e = parser.makeExpression("x+y");
		assertEquals(new Plus(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Plus(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Plus(new Plus(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Plus(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Plus(new Plus(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");

		assertEquals(new Plus(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Plus(new X(), new Plus(new Y(), new RGBColor(1, 1, 1))), e);

		//assertEquals(new Plus(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		//assertEquals(new Plus(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);

	}
	
	
	@Test
	public void floorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);


		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Plus(new X(), new Y())), e);


		e = parser.makeExpression("floor( x + y )");
		//assertEquals(new Floor(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void absoluteValueFunctionTest() {
		ExpressionTreeNode e = parser.makeExpression("abs( x )");
		assertEquals(new Abs(new X()), e);
		
		e = parser.makeExpression("floor( x + y )"); 
		//assertEquals(new Abs(new Plus(new X(), new Y())), e);

	}
	
	@Test
	public void sinFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("sin(x)");
		assertEquals(new Sin(new X()), e);
				
	}

	@Test
	public void cosFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("cos(x)");
		assertEquals(new Cos(new X()), e);

	}
	
	@Test
	public void MinusExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x-y");
		assertEquals(new Minus(new X(), new Y()), e);
		
		e=parser.makeExpression("1 - 1");
		assertEquals(new Minus(new Constant(1), new Constant(1)), e);
	}
	
	@Test
	public void RGB2YCRCRFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("RGB2YCRCR(y)");
		assertEquals(new RGB2YCRCR(new Y()), e);
  }
  
  @Test
	public void tanFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("tan(x)");
		assertEquals(new Tan(new X()), e);
				
	}
	
	@Test
	public void assignmentFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("a=cos(y)");
		assertEquals(new Cos(new Y()), e);
	}


	@Test
	public void expFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("exp(x)");
		assertEquals(new Exp(new X()), e);
				
	}
	
	@Test
	public void YCRCB2RGBFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("YCRCB2RGB(x)");
		assertEquals(new YCRCB2RGB(new X()), e);
				
	}
	
	@Test
	public void multFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("x*y");
		assertEquals(new Mult(new X(), new Y()), e);
				
	}
  
  @Test
	public void atanFunctionTests() {
		ExpressionTreeNode e= parser.makeExpression("atan(x)");
		assertEquals(new Atan(new X()), e);

	}
  
  @Test
  	public void modFunctionTests() {
	  ExpressionTreeNode e = parser.makeExpression("x%y");
	  assertEquals(new Mod(new X(), new Y()), e);
  }
  
  @Test
  	public void negateFunctionTests() {
	  ExpressionTreeNode e = parser.makeExpression("!x");
	  assertEquals(new Negate(new X()), e);
  }
  
  @Test
  	public void perlinColorFunctionTests() {
	  ExpressionTreeNode e = parser.makeExpression("perlinColor(x, y)");
	  assertEquals(new PerlinColor(new X(), new Y()), e);
  }

  @Test
  public void perlinBWFunctionTests() {
  ExpressionTreeNode e = parser.makeExpression("perlinBW(x, y)");
  assertEquals(new PerlinBW(new X(), new Y()), e);
}
  

}
