package net.tuto2.ws.client;

public class App 
{
    public static void main( String[] args )
    {
        MyConcatAgent agent = new MyConcatAgent();
        WSConcat wsconcat = agent.getWSConcatImplPort();
        String output = wsconcat.concat("Hello Concat ", "World!");

        System.out.println(output);
    }
}
