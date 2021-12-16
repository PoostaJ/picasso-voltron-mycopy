/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.chars.StringToken;

/**
 * Handles parsing for the PerlinColor function
 * 
 * @author Patrick Stoffel
 *
 */
public class PerlinColorAnalyzer implements SemanticAnalyzerInterface {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		 
		ExpressionTreeNode right= SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left= SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new PerlinColor(left, right);
	}

}
