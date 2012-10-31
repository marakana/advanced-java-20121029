import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private static class Worker implements Runnable {

		private final Socket client;

		public Worker(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				try {
					System.out.println(in.readLine());
				} finally {
					in.close();
				}
			} catch (IOException e) {
			}
		}

	}

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(31337);
			try {
				ExecutorService workers = Executors.newFixedThreadPool(10);
				while (true) {
					Socket client = server.accept();
					workers.submit(new Worker(client));
				}
			} finally {
				server.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
