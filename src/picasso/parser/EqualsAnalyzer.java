/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.language.Assignment;
import picasso.parser.tokens.IdentifierToken;

/**
 * @author Jackson Jacobs
 * @author Dario Fumarola
 *
 */

public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	/**
	 * Creates the expression tree related to the specific token inputted
	 * 
	 * @return the expression tree node 
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		ExpressionTreeNode rightExp= SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		IdentifierToken var= (IdentifierToken) tokens.pop();

		return Assignment.getInstance().addExpression(var.getName(), rightExp);
	}

}
