package ex2_3_time_server_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        boolean tryAgain = true;
        int myPort = 0;
        while (tryAgain) {
            System.out.println("Write port number");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt() == true) {
                myPort = sc.nextInt();
                tryAgain = false;
                startServer(myPort);
            } else {
                System.out.println("not a number, try again");
            }
        }
    }

    public static void startServer(int myPort) throws IOException {
        
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        
        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", myPort));

        System.out.println("Server log: Server created");
        System.out.println("Server log: Listening for clients on port " + myPort + "...");

        System.out.println("Server log: Waiting for connection.....");
        clientSocket = serverSocket.accept(); // vent på en kliente opretter Socket serveren

        System.out.println("Connection successful"); // forbindelsen oprettet
        System.out.println("Waiting for input....."); 

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // sender til klienten
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // modtager fra klienten

        String inputLine;
        
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("Bye.")) {
                System.out.println("connection is closed.");
                break;
            }
            if(inputLine.equals("tid")){
                System.out.println(new Date());
                out.println(new Date());
            }
            else {
                System.out.println(inputLine);
                out.println(inputLine.toUpperCase());
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
