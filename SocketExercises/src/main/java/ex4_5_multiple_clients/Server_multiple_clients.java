package ex4_5_multiple_clients;

import java.net.*;

public class Server_multiple_clients {

    public Server_multiple_clients(String ip, int port) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(ip, port));

            System.out.println("Server log: Server is created...");
            System.out.println("Server log: listning for clients on port " + port + " ...");

            try 
            {
                System.out.println("Server log: Waiting for connections..."); 
                    
                while (true) 
                {
                    new ServerClientThread( serverSocket.accept() );
                }
            }
            catch(Exception e)
            {
                System.err.println( "Server log: Accepting connection failed..." );
            }

        } catch (Exception ex) {
            System.out.println("Server log: Could not listen on port: " + port + "...");
        }
    }
}
