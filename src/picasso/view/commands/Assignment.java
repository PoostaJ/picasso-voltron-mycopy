package picasso.view.commands;

import java.util.*;
import picasso.parser.language.CharConstants;

/**
 * Creates the hashmap to be used by Picasso 
 * 
 * @author Jackson Jacobs
 * @author Dario Fumarola
 *
 */
public class Assignment {
	
	private static Assignment ourInstance;
	private static HashMap<String, String> ourMap;
	
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
		ourMap= new HashMap<String, String>();
	}
	
	/**
	 * Returns the value associated with the key in the hashmap.
	 * 
	 * @param key the key to access the dictionary
	 * @return the value associated with the key
	 */
	public String get(String key) {
		return ourMap.get(key);
	}	
	
	/**
	 * Splits the input and assigns one half to the key, the other to the value in
	 * the hashmap. 
	 * 
	 * @param input the input to split and assign key and value to
	 */
	public void assign(String input) {
		String[] a= input.split(Character.toString(CharConstants.EQUAL));
		String key= a[0];
		String value= a[1];
		
		key.strip();
		
		ourMap.put(key, value);
	}
	
	public String check(String input) {
		
		if (get(input)!=null) {
			input= get(input);
		}
		else if (input.contains(Character.toString(CharConstants.EQUAL))) {
			assign(input);
			String[] arr=input.split(Character.toString(CharConstants.EQUAL));
			input=arr[1];
		}
		return input;
	}
}
