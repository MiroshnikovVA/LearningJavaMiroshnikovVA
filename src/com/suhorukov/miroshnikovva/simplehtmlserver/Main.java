package com.suhorukov.miroshnikovva.simplehtmlserver;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 17.07.13
 * Time: 19:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args)  {
        SimpleHttpServer server = new SimpleHttpServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
