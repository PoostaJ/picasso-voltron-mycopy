package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the floor function.
 * 
 * @author Patrick Stoffel
 * 
 */
public class AbsAnalyzer extends UnaryFunctionAnalyzer {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Floor(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
