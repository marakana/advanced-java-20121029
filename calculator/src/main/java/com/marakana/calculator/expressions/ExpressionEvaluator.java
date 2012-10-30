package com.marakana.calculator.expressions;

public class ExpressionEvaluator {

	public static int evaluateExpression(Expression e) {
		if (e instanceof NumberExpression)
			return evaluateNumberExpression((NumberExpression) e);
		if (e instanceof OperationExpression)
			return evaluateOperationExpression((OperationExpression) e);
		throw new IllegalArgumentException("unknown expression type");
	}

	public static int evaluateNumberExpression(NumberExpression e) {
		return e.getNumber();
	}

	public static int evaluateOperationExpression(OperationExpression e) {
		return e.getOp().operate(evaluateExpression(e.getLhs()), evaluateExpression(e.getRhs()));
	}

}
