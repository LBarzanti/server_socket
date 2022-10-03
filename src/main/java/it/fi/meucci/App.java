package it.fi.meucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[])
    {
        serverStr servente = new serverStr();
       while (true)
       {
            servente.attendi();
            servente.comunica();
       }
    }
}


