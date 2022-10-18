package it.fi.meucci;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket ss = new ServerSocket(25565);
        for (int index = 1; index > 0; index++) 
        {
            Socket s = ss.accept();
            System.out.println("connessione effettuata");
            SrvThread t = new SrvThread(s);
            t.start();
        }
        ss.close();
    }
}


