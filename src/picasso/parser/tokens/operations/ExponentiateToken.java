package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the exponentiation sign token
 * @author Dario Fumarola
 */
public class ExponentiateToken extends CharToken implements OperationInterface {

	public ExponentiateToken() {
		super(CharConstants.EXPONENT);
	}

}
