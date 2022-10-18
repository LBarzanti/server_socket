package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SrvThread extends Thread
{
    Socket s;
    public SrvThread(Socket s)
    {
        this.s = s;
    }

    public void run()
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            for(;;)
            {
                String x = in.readLine();
                System.out.println(x);
                if (x==null || x.equals("fine") || x.equals("FINE")) 
                {
                    this.s.close();
                    break;
                }
                else
                {
                    System.out.println("invio la stringa maiuscola");
                    out.writeBytes(x.toUpperCase()+"\n");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            //System.exit(1);
        }
    }
}