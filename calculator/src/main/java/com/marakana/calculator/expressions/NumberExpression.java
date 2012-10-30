package com.marakana.calculator.expressions;

public class NumberExpression implements Expression {
	private final int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	@Override
	public int evaluate() {
		return number;
	}

	@Override
	public String infix() {
		return Integer.toString(number);
	}

}
