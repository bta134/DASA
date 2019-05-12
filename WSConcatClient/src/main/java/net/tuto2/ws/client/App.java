package net.tuto2.ws.client;
import net.tuto2.ws.client.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MyConcatAgent ws = new MyConcatAgent();
        WSConcat wsconcat = ws.getWSConcatImplPort();
        String text = wsconcat.concat("Java", "Service");
        System.out.println( text );
    }
}
