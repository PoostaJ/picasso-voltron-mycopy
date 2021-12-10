package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Tan;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Tan function
 * 
 * @author Dario Fumarola
 */

public class TanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		return new Tan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}

