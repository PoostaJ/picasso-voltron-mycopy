package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.Token;
import picasso.view.commands.Assignment;

public class AssignmentTests {
	
	private Assignment instance;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		instance= Assignment.getInstance();
	}
	
	@Test
	public void testCheck() {
		String input= "a=cos(x)";
		assertEquals(instance.check(input), "cos(x)");
		
		String input2= "cos(x)";
		assertEquals(instance.check(input2), "cos(x)");
		
		String input3= "a";
		assertEquals(instance.check(input3), "cos(x)");
	}
	
	@Test
	public void testGet() {
		String input="a=floor(y)";
		instance.check(input);
		assertEquals(instance.get("a"), "floor(y)");
	}
	
	@Test
	public void testAssign() {
		String input= "c=sin(1)";
		instance.assign(input);
		assertEquals(instance.get("c"), "sin(1)");
		
	}

}
