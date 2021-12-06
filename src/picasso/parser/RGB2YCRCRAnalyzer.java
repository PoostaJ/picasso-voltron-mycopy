package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGB2YCRCR;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the RgbToYCrCb function
 * 
 * @author Jackson Jacobs
 */

public class RGB2YCRCRAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		return new RGB2YCRCR(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
