package com.jtk14b.numericalcomputation;

public class PolynomialElement implements Comparable<PolynomialElement>{

	private double coefficient;
	private double degree;
	
	public PolynomialElement(double coefficient, double degree) {
		this.coefficient = coefficient;
		this.degree = degree;
	}
	
	public double getCoefficient() {
		return coefficient;
	}
	
	protected void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	
	public double getDegree() {
		return degree;
	}
	
	protected void setDegree(double degree) {
		this.degree = degree;
	}

	@Override
	public int compareTo(PolynomialElement element) {
		return (int) (element.degree - this.degree);
	}
	
}
