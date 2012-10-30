package com.marakana.calculator.expressions.visitors;

import com.marakana.calculator.expressions.NumberExpression;
import com.marakana.calculator.expressions.OperationExpression;

public class ExpressionPostfixSerializer implements ExpressionVisitor<String> {

	@Override
	public String visitNumberExpression(NumberExpression e) {
		return Integer.toString(e.getNumber());
	}

	@Override
	public String visitOperationExpression(OperationExpression e) {
		return String.format("%s %s %s", e.getLhs().accept(this), e.getRhs().accept(this), e.getOp());
	}

}
