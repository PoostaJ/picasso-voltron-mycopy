package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Minus;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the minus or "minus function".
 * 
 * @author Jackson Jacobs
 * 
 */
public class MinusAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		
		return new Minus(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens), SemanticAnalyzer.getInstance().generateExpressionTree(
						tokens) );
	}
}
