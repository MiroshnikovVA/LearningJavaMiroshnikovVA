package com.suhorukov.miroshnikovva.simplehtmlserver;

import com.suhorukov.miroshnikovva.dirindexhtml.DirHtmlGenerator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 17.07.13
 * Time: 19:41
 * To change this template use File | Settings | File Templates.
 */
public class SimpleHttpServer {
    public void start() throws IOException {
        ServerSocket s = new ServerSocket(8080);
        DirHtmlGenerator generator = new DirHtmlGenerator(".");
        while(true){
            Socket clientS = s.accept();
            System.out.println("Получено соединение от:"+clientS.getInetAddress()
                    +":"+clientS.getPort());
            new Thread(new HttpClient(clientS, generator), "client thread").start();
        }
    }
}
