package com.suhorukov.miroshnikovva.dirindexhtml;

import java.io.File;

/**
 * Точка входа в прогамму дял запуска генератора html файла
 */
public class Main {
    public static void main(String[] args) {
        DirHtmlGenerator generator = new DirHtmlGenerator("");
        try {
            generator.generateHtml(".");
        } catch (Http404Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
