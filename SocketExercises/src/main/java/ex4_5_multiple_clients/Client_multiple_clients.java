package ex4_5_multiple_clients;

import java.io.*;
import java.net.*;

public class Client_multiple_clients extends Thread {

    private Socket clientSocket;
    private PrintWriter toServer;
    private BufferedReader fromServer;

    private String input, output;
    private BufferedReader clientInput;

    public Client_multiple_clients(String ip, int port) throws IOException {
        clientInput = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Client message: Attemping connect to host " + ip + " on port " + port + " ...");

            clientSocket = new Socket(ip, port);
            toServer = new PrintWriter(clientSocket.getOutputStream(), true);//sender inputs til serveren
            fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));// får inputs fra 

            System.out.println("Client message: Connected to the server! ");

            System.out.println("Server message: " + fromServer.readLine());
            
            System.out.println("Client input: ");

            while ((input = clientInput.readLine()) != null) 
            {
                toServer.println(input); // sender input til server
                
                output = fromServer.readLine();
                
                System.out.println("Server message: " + output);
                
                if(input.equals("GOODBYE"))
                {
                    System.out.println("Client message: Disconnected from the server!" );

                    break;
                }
                System.out.println("Client input: ");
            }
            
            clientInput.close();
            toServer.close();
            fromServer.close();
            clientSocket.close();

        } catch (Exception e) {
            System.out.println("Client message: Unabe to connect to host: " + ip + " on port " + port);
        }

    }

}
