package com.suhorukov.miroshnikovva.task3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Properties pr =System.getProperties();
        for (Object k : pr.keySet())
        {
            System.out.println(k + " - " + pr.get(k));
        }
        System.out.println(pr.get("file.encoding"));
    }

    void a(InputStream srcStream, OutputStream destStream) throws IOException {
        byte[] b = new byte[100];
        int k;
        do {
            k = srcStream.read(b,0,b.length);
            destStream.write(b,0,k);
        }  while (k>0);
    }
}
