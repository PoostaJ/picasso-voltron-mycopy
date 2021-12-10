package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.YCRCB2RGB;
import picasso.parser.tokens.Token;


/**
 * Handles parsing the exponent function.
 * 
 * @author Patrick Stoffel
 * 
 */
public class YCRCB2RGBAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {		
		tokens.pop();
		return new YCRCB2RGB(SemanticAnalyzer.getInstance().generateExpressionTree(
			tokens));
	}

}
