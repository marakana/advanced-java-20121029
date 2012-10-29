package com.marakana.calculator;

import java.util.Stack;

public class Calculator {

	public static boolean handleNumber(String token, Stack<Integer> stack) {
		try {
			stack.push(Integer.parseInt(token));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean handleOperator(String token, Stack<Integer> stack) {
		if (token.length() != 1)
			return false;

		int lhs, rhs;
		switch (token.charAt(0)) {
		case '+':
			rhs = stack.pop();
			lhs = stack.pop();
			stack.push(lhs + rhs);
			return true;
		case '-':
			rhs = stack.pop();
			lhs = stack.pop();
			stack.push(lhs - rhs);
			return true;
		case '*':
			rhs = stack.pop();
			lhs = stack.pop();
			stack.push(lhs * rhs);
			return true;
		case '/':
			rhs = stack.pop();
			lhs = stack.pop();
			stack.push(lhs / rhs);
			return true;
		default:
			return false;
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: Calculator <expression>");
			return;
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (String token : args[0].split(" ")) {
			if (!handleNumber(token, stack) && !handleOperator(token, stack)) {
				System.err.println("invalid expression");
				return;
			}
		}
		System.out.println(stack.pop());

		/*
		 * Create an empty stack of integers Tokenize the expression string
		 * (split on whitespace) For each token: - if it's a number, push it -
		 * if it's [ + - * / ], pop two operands, do the operation and push the
		 * result - if it's garbage, print an error The result is the last thing
		 * left on the stack
		 */
	}
}
