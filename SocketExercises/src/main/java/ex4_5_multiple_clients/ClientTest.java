package ex4_5_multiple_clients;

import interfaces.DataReady;
import java.io.IOException;

public class ClientTest implements DataReady{
    
    public void test() throws IOException
    {
        Client_thread client = new Client_thread();
        client.setClient(this);
        client.connect("127.0.0.1", 8888);
        client.start();
        client.send("uh8uhygyhy");
        client.send("uh8uhysadfsdgyhy");
        client.send("uh8uhygyhy");
        client.send("uh8udfsdahygyhy");
    }
    
    public static void main(String[] args) throws Exception
    {
        ClientTest clientTest = new ClientTest();
        clientTest.test();
    }

    @Override
    public void data(String d) {
        System.out.println(d);
    }
    
}
