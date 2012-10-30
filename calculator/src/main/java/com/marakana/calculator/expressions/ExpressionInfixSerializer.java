package com.marakana.calculator.expressions;

public class ExpressionInfixSerializer {

	public static String serializeExpression(Expression e) {
		if (e instanceof NumberExpression)
			return serializeNumberExpression((NumberExpression) e);
		if (e instanceof OperationExpression)
			return serializeOperationExpression((OperationExpression) e);
		throw new IllegalArgumentException("unknown expression type");
	}

	public static String serializeNumberExpression(NumberExpression e) {
		return Integer.toString(e.getNumber());
	}

	public static String serializeOperationExpression(OperationExpression e) {
		return String.format("(%s %s %s)", serializeExpression(e.getLhs()), e.getOp(), serializeExpression(e.getRhs()));
	}

}
