package com.marakana.concurrency;

import java.math.BigInteger;
import java.util.Random;

public class Fibonacci {

	private static final Random random = new Random();

	public static BigInteger fib(int index) {
		switch (index) {
		case 0:
		case 1:
			return BigInteger.ONE;
		default:
			return fib(index - 1).add(fib(index - 2));
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				public void run() {
					int input = random.nextInt(40);
					BigInteger output = fib(input);
					System.out.format("fib(%d) = %s\n", input, output);
				}
			};
			t.start();
		}
	}

}
