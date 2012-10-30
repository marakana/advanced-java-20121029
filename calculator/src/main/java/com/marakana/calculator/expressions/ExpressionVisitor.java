package com.marakana.calculator.expressions;

public interface ExpressionVisitor<T> {
	T visitNumberExpression(NumberExpression e);
	T visitOperationExpression(OperationExpression e);
}
