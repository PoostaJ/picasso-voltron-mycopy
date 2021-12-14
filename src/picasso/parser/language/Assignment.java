package picasso.parser.language;

import java.util.*;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

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
	private static File myFile;
	
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
		if (key.equals("x") || key.equals("y")) {
			throw new IllegalArgumentException("Cannot assign X or Y to new values!");
		}
		ourMap.put(key, expr);
		return expr;
	}
	
	public ExpressionTreeNode getExpression(String key) {
		return ourMap.get(key);
	}
	
	public void writeToFile(String s) {
		try {
			myFile= new File("varExpressions.txt");
			FileWriter myWriter = new FileWriter(myFile, true);
			myWriter.write(s+"\n");
			myWriter.close();
			myFile.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readFromFile() {
		StringBuilder sb= new StringBuilder();
		BufferedReader myReader = null;
		try {
			myReader = new BufferedReader(new FileReader(myFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String currentLine;
		try {
			
			while ((currentLine = myReader.readLine()) != null) {
				sb.append(currentLine);
				sb.append("\n");
			}
			myReader.close();
			return sb.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}	
}
