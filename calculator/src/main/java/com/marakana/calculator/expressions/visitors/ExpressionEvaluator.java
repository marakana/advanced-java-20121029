package com.marakana.calculator.expressions.visitors;

import com.marakana.calculator.expressions.NumberExpression;
import com.marakana.calculator.expressions.OperationExpression;

public class ExpressionEvaluator implements ExpressionVisitor<Integer> {

	@Override
	public Integer visitNumberExpression(NumberExpression e) {
		return e.getNumber();
	}

	@Override
	public Integer visitOperationExpression(OperationExpression e) {
		return e.getOp().operate(e.getLhs().accept(this), e.getRhs().accept(this));
	}

}
