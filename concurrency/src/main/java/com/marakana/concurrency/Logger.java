package com.marakana.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class Logger implements Runnable {

	Queue<String> queue = new LinkedList<String>();

	public void log(String message) {
		synchronized (this) {
			queue.add(message);
			notify();
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (queue.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
					}
				} else {
					System.out.println(queue.remove());
				}
			}
		}
	}

}
