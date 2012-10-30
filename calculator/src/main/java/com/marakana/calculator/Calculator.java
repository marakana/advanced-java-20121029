package com.marakana.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.marakana.calculator.expressions.Expression;
import com.marakana.calculator.expressions.NumberExpression;
import com.marakana.calculator.expressions.OperationExpression;

public class Calculator {

	private static Map<String, Operator> operators;

	static {
		operators = new HashMap<String, Operator>();
		operators.put("+", Operator.ADD);
		operators.put("-", Operator.SUBTRACT);
		operators.put("*", Operator.MULTIPLY);
		operators.put("/", Operator.DIVIDE);
	}

	public static boolean handleNumber(String token, Stack<Expression> stack) {
		try {
			stack.push(new NumberExpression(Integer.parseInt(token)));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean handleOperator(String token, Stack<Expression> stack) {
		Operator op = operators.get(token);
		if (op == null)
			return false;
		
		Expression rhs = stack.pop(), lhs = stack.pop();
		stack.push(new OperationExpression(op, lhs, rhs));
		return true;
	}

	public static Expression parse(String expression) {
		Stack<Expression> stack = new Stack<Expression>();
		for (String token : expression.split(" ")) {
			if (!handleNumber(token, stack) && !handleOperator(token, stack)) {
				throw new IllegalArgumentException("malformed expression");
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: Calculator <expression>");
			return;
		}

		Expression expression = parse(args[0]);
		System.out.println(expression.infix() + " = " + expression.evaluate());
	}
}
