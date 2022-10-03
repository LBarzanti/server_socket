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
        System.out.println("SERVER partito in esecuzione ...");
        servente.attendi();
    }
}


