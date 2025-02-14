import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Write Connect to connect to the server: ");
        String h = "";
        try {
            BufferedReader connect = new BufferedReader(new InputStreamReader(System.in));
             h = connect.readLine();
        }catch (IOException e){
            System
            .out.println("Error");
        }
         if (h.equalsIgnoreCase("connect")){
            System.out.println("Connected");
        try {
            // Get the server IP address from user input
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter server IP address: ");

            String serverIP = consoleReader.readLine();
            Socket socket = new Socket(serverIP, 3000);                     // Use the same port number as the server
            System.out.println("Connected to the server.");

            // Setup input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Start a thread to read messages from the server
            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Read messages from the console and send them to the server
            String message;
            while ((message = consoleReader.readLine()) != null) {
                out.println(message);
                if (message.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            // Close resources
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }}
         else {
            System.out.println("Not Connected");
    }}
}