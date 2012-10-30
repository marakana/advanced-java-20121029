package com.marakana.calculator.expressions;

import com.marakana.calculator.expressions.visitors.ExpressionVisitor;

public class NumberExpression implements Expression {

	private final int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitNumberExpression(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		NumberExpression other = (NumberExpression) obj;
		if (number != other.number)
			return false;
		return true;
	}

}
