package picasso.parser.language;

import java.util.*;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Creates the hashmap to be used by Picasso 
 * 
 * @author Jackson Jacobs
 * @author Dario Fumarola
 *
 */
public class Assignment {
	
	private static Assignment ourInstance;
	private static HashMap<String, ExpressionTreeNode> ourMap;
	
	/**
	 * Make sure that there is only one Assignment hashmap for the application.
	 * 
	 * @return the semantic analyzer
	 */
	public static Assignment getInstance() {
		if (ourInstance== null) {
			ourInstance= new Assignment();
		}
		return ourInstance;
	}

	/**
	 * Assignment Constructor.
	 */
	private Assignment() {
		ourMap= new HashMap<String, ExpressionTreeNode>();
	}
	
	public ExpressionTreeNode addExpression(String key, ExpressionTreeNode expr) {
		ourMap.put(key, expr);
		return expr;
	}
	
	public ExpressionTreeNode getExpression(String key) {
		return ourMap.get(key);
	}
	

}
