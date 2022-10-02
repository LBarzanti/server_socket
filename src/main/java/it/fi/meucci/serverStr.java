package it.fi.meucci;
import java.net.*;
import java.io.*;
import java.util.*;

public class serverStr
{
    ServerSocket server = null;
    Socket client = null;
    String ricevuto = null;
    String modificato = null;
    BufferedReader reader;
    DataOutputStream writer;

    public Socket attendi()
    {
        try
        {
            System.out.println("SERVER partito in esecuzione ...");
            server = new ServerSocket(25565);
            client = server.accept();
            server.close();
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new DataOutputStream(client.getOutputStream());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server !");
            System.exit(1);
        }
        return client;
    }

    public void comunica()
    {
        try 
        {
            System.out.println("connessione effettuata");
            ricevuto=reader.readLine();
            System.out.println("ricevuto il messaggio: " + ricevuto);
            modificato=ricevuto.toUpperCase();
            writer.writeBytes(modificato + "\n");
            System.out.println("invio risultati");
            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
