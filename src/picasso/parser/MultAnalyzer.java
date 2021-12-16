package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Mult;
import picasso.parser.tokens.Token;


/**
 * Handles parsing the multiplication or "multiplication function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Patrick Stoffel
 * 
 */
public class MultAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		ExpressionTreeNode right= SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left= SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new Mult(left, right);
	}

}
