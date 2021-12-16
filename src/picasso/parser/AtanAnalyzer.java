package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Atan;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Arctangent function
 * 
 * @author Jackson Jacobs
 * 
 */

public class AtanAnalyzer extends UnaryFunctionAnalyzer {

	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		return new Atan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}