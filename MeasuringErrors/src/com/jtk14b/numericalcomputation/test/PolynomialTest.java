package com.jtk14b.numericalcomputation.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jtk14b.numericalcomputation.PolynomialFunction;

public class PolynomialTest {
	
	//TODO Testing from class Calculator
	private static String expression;
	private static PolynomialFunction function;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
//		expression = "x^2+2x^3-3x^-2+x^1+5x+3+5";
//		expression = "x^2+4x^2+x";
		expression = "x^2 + 6x + 10";
		System.out.println(expression.replaceAll("(\\s|\\n)", ""));
		function = new PolynomialFunction(expression);
		function.printFunction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void regexTest() {
		Pattern pattern = Pattern.compile("[+]?(-?\\d+)?[x]?(\\^(-?\\d+))?");
		Matcher matcher = pattern.matcher(expression);
		int x = 0;
		while (matcher.find()) {			
			x++;
			System.out.println(matcher.group(0));
		    System.out.println("Group " + x + " Coeff: " + matcher.group(1));
		    System.out.println("Group " + x + " Degree: " + matcher.group(2));
		}
	}

	@Test
	public void mainTest() {
		
		
	}

}
