package com.marakana.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger implements Runnable {

	BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	public void log(String message) {
		try {
			queue.put(message);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
			}
		}
	}

}
