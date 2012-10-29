package com.marakana.calculator;

public class Calculator {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: Calculator <expression>");
			return;
		}
		
		String expression = args[0];
		/*
		 * Create an empty stack of integers
		 * Tokenize the expression string (split on whitespace)
		 * For each token:
		 *   - if it's a number, push it
		 *   - if it's [ + - * / ], pop two operands, do the operation and push the result
		 *   - if it's garbage, print an error
		 * The result is the last thing left on the stack
		 */
	}
}
