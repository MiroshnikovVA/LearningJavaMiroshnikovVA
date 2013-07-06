package com.suhorukov.miroshnikovva.task3;

import java.util.Properties;

/**
 * User: MiroshnikovVA
 * Date: 29.06.13
 */
public class Main {
    public static void main(String[] args) {
        Properties pr =System.getProperties();
        for (Object k : pr.keySet())
        {
            System.out.println(k + " - " + pr.get(k));
        }
        System.out.println(pr.get("file.encoding"));
    }
}
