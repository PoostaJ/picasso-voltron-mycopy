package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Random;
import picasso.parser.tokens.Token;

/**
 * Handles parsing for the function that handles random color.
 * 
 * @author Dario Fumarola
 * 
 */
public class RandomAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		

		
	//	StringToken token = (StringToken) tokens.pop();

		return new Random();
	}

}

