package com.jtk14b.numericalcomputation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialFunction {

	/**
	 * Elements from the given function
	 */
	private List<PolynomialElement> elements;
	
	public PolynomialFunction() {
		elements = new ArrayList<PolynomialElement>();
	}
	
	public PolynomialFunction(String expression) {
		elements = new ArrayList<PolynomialElement>();
		parseStringToPolynomial(expression);
	}
	
	public List<PolynomialElement> getElements() {
		return elements;
	}
	
	/**
	 * Simplify the function by summing the elements with the others with the same degree
	 */
	private void simplifyFunction() {
		//TODO Clean code
		PolynomialElement simplifiedElement = null;
		List<PolynomialElement> simplifiedElements =
				new ArrayList<PolynomialElement>();
		
		double prevDegree = 0;
		for (PolynomialElement element : elements) {
			if (simplifiedElement == null) {
				simplifiedElement =
						new PolynomialElement(
								element.getCoefficient(),
								element.getDegree());
				
				prevDegree = element.getDegree();
			}
			else if (element.getDegree() != prevDegree) {
				simplifiedElements.add(simplifiedElement);
				simplifiedElement =
						new PolynomialElement(
								element.getCoefficient(),
								element.getDegree());
				
				prevDegree = element.getDegree();
			}
			else {
				simplifiedElement.setCoefficient(
						simplifiedElement.getCoefficient()
						+ element.getCoefficient());
			}
		}
		simplifiedElements.add(simplifiedElement);
		
		elements = simplifiedElements;
	}
	
	/**
	 * Parsing string to polynomial expression
	 * 
	 * @param expression
	 */
	public void parseStringToPolynomial(String expression) {
		//FIXME Robusting regex
		Pattern pattern = Pattern.compile("[+]?(-?\\d+)?[x]?(\\^(-?\\d+))?");
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) {
			if (!matcher.group(0).isEmpty()) {
				if(matcher.group(1) == null && matcher.group(2) == null) {
					elements.add(new PolynomialElement(1, 1));
				}
				else if (matcher.group(1) == null) {
					elements.add(
							new PolynomialElement(
									1,
									Double.parseDouble(
											matcher.group(2).substring(1))));
				}
				else if (matcher.group(2) == null) {
					if (matcher.group(0).contains("x")) {
						elements.add(
								new PolynomialElement(
										Double.parseDouble(matcher.group(1)),
										1));
					}
					else {
						elements.add(
								new PolynomialElement(
										Double.parseDouble(matcher.group(1)),
										0));
					}
				}
				else {
					elements.add(
							new PolynomialElement(
									Double.parseDouble(matcher.group(1)),
									Double.parseDouble(
											matcher.group(2).substring(1))));
				}
			}
		}
	}

	/**
	 * Printing the function
	 */
	public void printFunction() {
		simplifyFunction();
		
		System.out.print("f(x) = ");
		for (PolynomialElement element : elements) {
			System.out.print(
					"(" + element.getCoefficient() + ")x^"
					+ "(" + element.getDegree() + ")");
			
			if (element.equals(elements.get(elements.size() - 1))) {
				break;
			}
			
			System.out.print(" + ");
		}
		System.out.println();
	}

}
