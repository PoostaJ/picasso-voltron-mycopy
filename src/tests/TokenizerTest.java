package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
import picasso.parser.language.expressions.X;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.*;

public class TokenizerTest {

	Tokenizer tokenizer;
	List<Token> tokens;

	@BeforeEach
	public void setUp() throws Exception {
		tokenizer = new Tokenizer();
	}
	
	/**
	 * Test that parsing an expression with a comment works
	 */
	@Test
	public void testTokenizeComment() {
		String expression = "x // this is a comment";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(1, tokens.size());
		
		expression = "// everything is a comment";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(0, tokens.size());
	}

	/**
	 * Test that parsing a constant works
	 */
	@Test
	public void testTokenizeConstant() {
		String expression = ".324";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(.324), tokens.get(0));

		expression = "-1";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1), tokens.get(0));

		// No problems here; problem will be in next step (Semantic Analysis)
		expression = "-1.2";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1.2), tokens.get(0));
	}

	@Test
	public void testTokenizeColor() {
		String expression = "[1, 1, 1]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(1, 1, 1), tokens.get(0));

		expression = "[-1, 0, .5]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(-1, 0, .5), tokens.get(0));
	}

	@Test
	public void testTokenizeInvalidColor() {
		String expression = "[1, 1.0001, 1]";

		assertThrows(ParseException.class, () -> {
			tokens = tokenizer.parseTokens(expression);
		});
	}

	@Test
	public void testTokenizeBasicFunctionExpression() {
		String expression = "floor(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new FloorToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
	
	@Test
	public void testAbsTokenizeBasicFunctionExpression() {
		String expression = "abs(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new AbsToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
	}

	@Test
	public void testTokenizeSinFunctionExpression() {
		String expression= "sin(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new SinToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
	
	@Test
	public void testTokenizePlusFunctionExpression() {
		String expression= "x+y";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new PlusToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
	}


	@Test
	public void testTokenizeCosFunctionExpression() {
		String expression= "cos(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new CosToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
  
	@Test
	public void testTokenizeAssignmentExpression() {
		String expression= "a=cos(y)";
		tokens=tokenizer.parseTokens(expression);
		System.out.println(tokens);
		assertEquals(new IdentifierToken("a"), tokens.get(0));
		assertEquals(new EqualsToken(), tokens.get(1));
		assertEquals(new CosToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
	}
  
	@Test
	public void testTokenizeMinusFunctionExpression() {
		String expression= "x-y";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new MinusToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
		String expression2= "1 - 1";
		tokens=tokenizer.parseTokens(expression2);
		assertEquals(new NumberToken(1), tokens.get(0));
		assertEquals(new MinusToken(), tokens.get(1));
		assertEquals(new NumberToken(1), tokens.get(2));
	}

	@Test
	public void testTokenizeRgbToYCrCbFunctionExpression() {
		String expression= "RGB2YCRCR(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new RGB2YCRCRToken(), tokens.get(0));
  }  

	@Test
	public void testTokenizeTanFunctionExpression() {
		String expression= "tan(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new TanToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}


  @Test
	public void testTokenizeExpFunctionExpression() {
		String expression= "exp(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new ExpToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
  
  @Test
	public void testTokenizeYCRCB2RGBFunctionExpression() {
		String expression= "YCRCB2RGB(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new YCRCB2RGBToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
  
	@Test
	public void testTokenizeMultFunctionExpression() {
		String expression= "x*y";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new MultToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
	}
  
  @Test
	public void testTokenizeAtanFunctionExpression() {
		String expression= "atan(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new AtanToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
  
  @Test
  	public void testTokenizeModFunctionExpression() {
	  String expression = "x%y";
	  tokens = tokenizer.parseTokens(expression);
	  assertEquals(new IdentifierToken("x"), tokens.get(0));
	  assertEquals(new ModToken(), tokens.get(1));
	  assertEquals(new IdentifierToken("y"), tokens.get(2));
  }
  
  @Test
  	public void testTokenizeNegateFunction() {
	  String expression = "!x";
	  tokens = tokenizer.parseTokens(expression);
	  assertEquals(new NegateToken(), tokens.get(0));
	  assertEquals(new IdentifierToken("x"), tokens.get(1));
  }
  
  @Test
  	public void testTokenizePerlinColorFunction() {
	  String expression = "perlinColor(x, y)";
	  tokens = tokenizer.parseTokens(expression);
	  assertEquals(new PerlinColorToken(), tokens.get(0));
	  assertEquals(new LeftParenToken(), tokens.get(1));
	  assertEquals(new IdentifierToken("x"), tokens.get(2));
	  assertEquals(new CommaToken(), tokens.get(3));
	  assertEquals(new IdentifierToken("y"), tokens.get(4));
	  assertEquals(new RightParenToken(), tokens.get(5));
  	}


  @Test
	public void testTokenizeCombinedFunctionExpression() {
		String expression = "perlinColor(floor(x), y)";
		List<Token> tokens = tokenizer.parseTokens(expression);
		// TODO: Check the tokens...

		expression = "sin(perlinColor(x, y))";
		tokens = tokenizer.parseTokens(expression);
		
		expression = "perlinColor(x + y)";
		tokens = tokenizer.parseTokens(expression);
		// TODO: Check the tokens...
	}

	// TODO: Test arithmetic (rather than function-based) expressions ...

}
