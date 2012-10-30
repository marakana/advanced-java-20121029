package com.marakana.calculator.expressions;

import com.marakana.calculator.expressions.visitors.ExpressionVisitor;

public interface Expression {
	<T> T accept(ExpressionVisitor<T> visitor);
}
