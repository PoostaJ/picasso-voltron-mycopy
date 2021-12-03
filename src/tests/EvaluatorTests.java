/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.Token;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("[1, -1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testAbsEvaluation() {
		String abs1 = "abs(1)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		
		ExpressionTreeNode expr = expTreeGen.makeExpression(abs1);
		for ( int i = -1; i <= 1; i++ ) {
			assertEquals(new RGBColor(Math.abs(1), Math.abs(1), Math.abs(1)), expr.evaluate(i, i));
		}
		
		String abs2 = "abs(x)";
		expr = expTreeGen.makeExpression(abs2);
		for ( int i = -1; i <= 1; i++ ) {
			assertEquals(new RGBColor(Math.abs(i), Math.abs(i), Math.abs(i)), expr.evaluate(i, i));
		}
		
	}
	
  @Test
	public void testSinEvaluation() {
		String s= "sin(1)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		ExpressionTreeNode expr= expTreeGen.makeExpression(s);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.sin(1), Math.sin(1), Math.sin(1)), expr.evaluate(i, i));
		}
		
		String s2= "sin(x)";
		expr=expTreeGen.makeExpression(s2);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), expr.evaluate(i, i));
		}
		
		String s3= "sin(y)";
		expr=expTreeGen.makeExpression(s3);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), expr.evaluate(i, i));
		}
	}

  @Test
	public void testCosEvaluation() {
		String s= "cos(1)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		ExpressionTreeNode expr= expTreeGen.makeExpression(s);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.cos(1), Math.cos(1), Math.cos(1)), expr.evaluate(i, i));
		}
		
		String s2= "cos(x)";
		expr=expTreeGen.makeExpression(s2);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), expr.evaluate(i, i));
		}
		
		String s3= "cos(y)";
		expr=expTreeGen.makeExpression(s3);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), expr.evaluate(i, i));
		}
	}

	// TODO: More tests of evaluation

}
