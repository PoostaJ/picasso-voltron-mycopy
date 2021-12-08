package picasso.view.commands;

import java.util.*;
import java.lang.*;
import java.io.*;
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
	
	public static Assignment getInstance() {
		if (ourInstance== null) {
			ourInstance= new Assignment();
		}
		return ourInstance;
	}

	private Assignment() {
		ourMap= new HashMap<String, String>();
	}
	
	public String returnValue(String key) {
		return ourMap.get(key);
	}	
	
	public void assign(String input) {
		String[] a= input.split(Character.toString(CharConstants.EQUAL));
		String key= a[0];
		String value= a[1];
		
		key.strip();
		
		ourMap.put(key, value);
	}
	
	public String get(String input) {
		return ourMap.get(input);
	}
}

	//if map contains key, then return value of key
	//else if contains equal, then assign right to key of left
	//else run normally
