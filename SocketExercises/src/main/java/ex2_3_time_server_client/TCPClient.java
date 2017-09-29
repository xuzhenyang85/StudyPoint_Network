package ex2_3_time_server_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        String serverHostname = "127.0.0.1";

        System.out.println("Attemping to connect to host " + serverHostname + " on port 10007.");

        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            clientSocket = new Socket(serverHostname, 10007);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + serverHostname);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput ;

        System.out.print("input: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            if (userInput != null) {
                System.out.println("echo: " + in.readLine());
                System.out.print("input: ");
            } else {
                System.out.println("googbye");
            }
        }

        out.close();

        in.close();

        stdIn.close();

        clientSocket.close();
    }
}
