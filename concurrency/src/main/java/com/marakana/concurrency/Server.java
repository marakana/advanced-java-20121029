package com.marakana.concurrency;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

	private static class Worker implements Runnable, Closeable {

		private final Socket client;
		private final Logger logger;

		public Worker(Socket client, Logger logger) {
			this.client = client;
			this.logger = logger;
		}

		@Override
		public void run() {
			try {
				try {
					BufferedReader in = new BufferedReader(
							new InputStreamReader(client.getInputStream()));
					try {
						for (String line = in.readLine(); line != null; line = in.readLine()) {
							logger.log(line);
						}
					} finally {
						in.close();
					}
				} finally {
					client.close();
				}
			} catch (IOException e) {
			}
		}

		@Override
		public void close() throws IOException {
			client.close();
		}

	}

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(31337);
			try {
				// start a thread pool with ten threads, and run the logger
				ExecutorService threadPool = Executors.newFixedThreadPool(10);
				try {
					Logger logger = new Logger();
					threadPool.execute(logger);

					// accept client connections and hand them off to worker
					// threads
					while (true) {
						Socket client = server.accept();
						threadPool.execute(new Worker(client, logger));
					}
				} finally {
					for (Runnable task : threadPool.shutdownNow()) {
						Worker worker = (Worker) task;
						worker.close();
					}
				}
			} finally {
				server.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
