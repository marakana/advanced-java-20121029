package com.marakana.calculator.expressions;

import com.marakana.calculator.Operator;
import com.marakana.calculator.expressions.visitors.ExpressionVisitor;

public class OperationExpression implements Expression {

	private final Operator op;
	private final Expression lhs, rhs;

	public OperationExpression(Operator op, Expression lhs, Expression rhs) {
		this.op = op;
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Operator getOp() {
		return op;
	}

	public Expression getLhs() {
		return lhs;
	}

	public Expression getRhs() {
		return rhs;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitOperationExpression(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lhs.hashCode();
		result = prime * result + op.hashCode();
		result = prime * result + rhs.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationExpression other = (OperationExpression) obj;
		if (!lhs.equals(other.lhs))
			return false;
		if (op != other.op)
			return false;
		if (!rhs.equals(other.rhs))
			return false;
		return true;
	}

}
