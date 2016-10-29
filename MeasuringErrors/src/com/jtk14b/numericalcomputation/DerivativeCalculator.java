package com.jtk14b.numericalcomputation;

public class DerivativeCalculator {
	//TODO Adding comments
	public static double getApproximateValue(
			PolynomialFunction function,
			double x,
			double deltaX) {
		double value = 0;
		double fxDeltaX = 0;
		double fx = 0;
		
		for (PolynomialElement element : function.getElements()) {
			fxDeltaX = fxDeltaX
					+ element.getCoefficient()
					* (Math.pow((x + deltaX), element.getDegree()));
			
			fx = fx + element.getCoefficient() * (Math.pow(
					x,
					element.getDegree()));
		}
		
		value = value + (fxDeltaX - fx) / deltaX;
		
		return value;
	}
	
	public static double getTrueValue(PolynomialFunction function, double x) {
		double value = 0;
		
		for (PolynomialElement element : function.getElements()) {
			value = value
					+ element.getCoefficient()
					* element.getDegree()
					* Math.pow(x, element.getDegree() - 1);
		}
		
		return value;
	}
	
	public static double getApproximateError(
			PolynomialFunction function,
			double x,
			double previousDeltaX,
			double presentDeltaX) {
		double error =
				getApproximateValue(function, x, presentDeltaX)
				- getApproximateValue(function, x, previousDeltaX);
		
		if (error < 0) {
			error *= -1;
		}
		
		return error;
	}
	
	public static double getRelativeApproximateError(
			PolynomialFunction function,
			double x,
			double previousDeltaX,
			double presentDeltaX) {
		double error =
				getApproximateError(function, x, previousDeltaX, presentDeltaX)
				/ getApproximateValue(function, x, presentDeltaX);
		
		if (error < 0) {
			error *= -1;
		}
		
		return error;
	}
	
	public static double getTrueError(
			PolynomialFunction function,
			double x,
			double deltaX) {
		double error =
				getTrueValue(function, x)
				- getApproximateValue(function, x, deltaX);
		
		if (error < 0) {
			error *= -1;
		}
		
		return error;
	}
	
	public static double getRelativeTrueError(
			PolynomialFunction function,
			double x,
			double deltaX) {
		double error =
				getTrueError(function, x, deltaX) / getTrueValue(function, x);
		
		if (error < 0) {
			error *= -1;
		}
		
		return error;
	}

}
