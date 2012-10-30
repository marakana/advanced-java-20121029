package com.marakana.calculator.expressions;

import com.marakana.calculator.Operator;

public class OperationExpression implements Expression {
	private final Operator op;
	private final Expression lhs, rhs;

	public OperationExpression(Operator op, Expression lhs, Expression rhs) {
		this.op = op;
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public int evaluate() {
		return op.operate(lhs.evaluate(), rhs.evaluate());
	}

	@Override
	public String infix() {
		return String.format("(%s %s %s)", lhs.infix(), op, rhs.infix());
	}

}
