package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.chars.StringToken;

/**
 * Handles parsing for the function that handles image wrapping.
 * 
 * @author Dan Nguyen
 * 
 */
public class ImageWrapAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		
		ExpressionTreeNode rightExp = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode leftExp = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		StringToken token = (StringToken) tokens.pop();
		String value = token.value();
		return new ImageWrap(value, rightExp, leftExp);
	}

}

