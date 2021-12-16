package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
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
  	public void testTokenizePerlinBWFunction() {
	  String expression = "perlinBW(x, y)";
	  tokens = tokenizer.parseTokens(expression);
	  assertEquals(new PerlinBWToken(), tokens.get(0));
	  assertEquals(new LeftParenToken(), tokens.get(1));
	  assertEquals(new IdentifierToken("x"), tokens.get(2));
	  assertEquals(new CommaToken(), tokens.get(3));
	  assertEquals(new IdentifierToken("y"), tokens.get(4));
	  assertEquals(new RightParenToken(), tokens.get(5));
  	}



	@Test
	public void testTokenizeCombinedFunctionExpression() {
		String expression = "perlinBW(floor(x), y)";

		expression = "sin(perlinBW(x, y))";
		tokens = tokenizer.parseTokens(expression);
		
		expression = "perlinBW(x + y)";
		tokens = tokenizer.parseTokens(expression);
	}
	
	@Test
	public void testTokenizeCeilFunctionExpression() {
		String expression= "ceil(.6)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new CeilToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new NumberToken(0.6), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression= "ceil(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new CeilToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
	
	@Test
	public void testTokenizeClampFunctionExpression() {
		String expression= "clamp(x+.1)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new ClampToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new PlusToken(), tokens.get(3));
		assertEquals(new NumberToken(0.1), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		
		expression= "clamp(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new ClampToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
	
	@Test
	public void testTokenizeLogFunctionExpression() {
		String expression= "log(x+.1)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new LogToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new PlusToken(), tokens.get(3));
		assertEquals(new NumberToken(0.1), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		
		expression= "log(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new LogToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
	
	@Test
	public void testTokenizeRandomFunctionExpression() {
		String expression= "random()";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new RandomToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new RightParenToken(), tokens.get(2));
	}
	
	@Test
	public void testTokenizeWrapFunctionExpression() {
		String expression= "wrap(x+.1)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new WrapToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new PlusToken(), tokens.get(3));
		assertEquals(new NumberToken(0.1), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		
		expression= "wrap(y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new WrapToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
	
	@Test
	public void testTokenizeImageWrapFunctionExpression() {
		String expression= "imageWrap(vortex.jpg,x+x, y)";
		tokens= tokenizer.parseTokens(expression);
		assertEquals(new ImageWrapToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("vortex.jpg"), tokens.get(2));
		assertEquals(new CommaToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new PlusToken(), tokens.get(5));
		assertEquals(new IdentifierToken("x"), tokens.get(6));
		assertEquals(new CommaToken(), tokens.get(7));
		assertEquals(new IdentifierToken("y"), tokens.get(8));
		assertEquals(new RightParenToken(), tokens.get(9));
	}
	
	


}
