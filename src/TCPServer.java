import java.io.*;
import java.net.*;

public class TCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(3000);
			System.out.println("Server is running and waiting for a connection...");

			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

			String message;
			while (true) {
				if (in.ready()) {
					message = in.readLine();
					System.out.println("Client: " + message);
					if (message.equalsIgnoreCase("bye")) {
						break;
					}
				}

				if (inFromUser.ready()) {
					message = inFromUser.readLine();
					out.println("Server: " + message);
				}
			}

			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}