package com.suhorukov.miroshnikovva.simplehtmlserver;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 17.07.13
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */
public class TestHttpClient extends TestCase {

    void testYandex() throws IOException {
        Socket s = new Socket("vasya-pupkin-ok.narod.ru",80);
        OutputStreamWriter writer = new OutputStreamWriter(s.getOutputStream());
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line = "";
            writer.write("GET / HTTP/1.1\n");
            writer.write("Host: vasya-pupkin-ok.narod.ru:80\n");
            writer.write("Connection: keep-alive\n");
            writer.write("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;\n");
            writer.write("User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36\n");
            writer.write("Accept-Encoding: gzip,deflate,sdch\n");
            writer.write("Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4\n");
            writer.write("\r\n");
            writer.flush();
        do {
            line = reader.readLine();

            System.out.println(line);
        } while (line!=null);
        writer.close();
    }
}
