package com.marakana.calculator.expressions.visitors;

import com.marakana.calculator.expressions.NumberExpression;
import com.marakana.calculator.expressions.OperationExpression;

public interface ExpressionVisitor<T> {
	T visitNumberExpression(NumberExpression e);
	T visitOperationExpression(OperationExpression e);
}
