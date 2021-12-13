/**
 * 
 */
package picasso.parser.tokens.chars;

import picasso.parser.tokens.Token;

/**
 * A token represented by a string
 * <P>
 * 
 * @author Dan Nguyen
 */
public class StringToken extends Token {

	private final String myValue;

	/**
	 * Represents the string token
	 */
	public StringToken(String value) {
		super("String Token: ");
		myValue = value; 
	}

	/**
	 * @return true iff o is a StringToken with same value
	 */
	@Override
	public boolean equals(Object o) {
		if( o == this ) {
			return true;
		}
		if (!(o instanceof StringToken)) {
			return false;
		}
		StringToken other = (StringToken) o;
		return myValue == other.myValue;
	}

	/**
	 * @return the encapsulated value
	 */
	public String value() {
		return myValue;
	}

	@Override
	public String toString() {
		return super.toString() + (String) myValue;
	}

	@Override
	public boolean isConstant() {
		return false;
	}

	@Override
	public boolean isFunction() {
		return false;
	}
}
