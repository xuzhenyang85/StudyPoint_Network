package ex4_5_multiple_clients;

import interfaces.DataReady;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client_thread extends Thread {

    private Socket clientSocket;
    private PrintWriter toServer;
    private BufferedReader fromServer;
    DataReady client;

    public void connect(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        toServer = new PrintWriter(clientSocket.getOutputStream(), true);//sender inputs til serveren
        fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));// får inputs fra
    }

    public void send(String input) {
        toServer.println(input);
    }

    public void setClient(DataReady client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            String output;
            while (true) {
                output = fromServer.readLine();
                client.data(output);
            }

        } catch (IOException ex) {
            Logger.getLogger(Client_thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
