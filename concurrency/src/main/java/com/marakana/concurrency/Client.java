package com.marakana.concurrency;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class Client {

	private static final Random random = new Random();

	private static BigInteger fib(int index) {
		switch (index) {
		case 0:
		case 1:
			return BigInteger.ONE;
		default:
			return fib(index - 1).add(fib(index - 2));
		}
	}

	public static void main(String[] args) {
		try {
			Socket server = new Socket(InetAddress.getLocalHost(), 31337);
			try {
				PrintWriter out = new PrintWriter(server.getOutputStream());
				try {
					while (true) {
						int input = random.nextInt(30);
						BigInteger output = fib(input);
						out.println(String
								.format("fib(%d) = %s", input, output));
						out.flush();
					}
				} finally {
					out.close();
				}
			} finally {
				server.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
