/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the negate sign token
 * 
 * @author Patrick Stoffel
 *
 */
public class NegateToken extends CharToken implements OperationInterface {

	/**
	 * Creates the negate token
	 */
	public NegateToken() {
		super(CharConstants.BANG);
	}

}
