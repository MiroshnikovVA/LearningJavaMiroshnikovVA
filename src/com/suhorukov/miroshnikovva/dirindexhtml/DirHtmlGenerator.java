package com.suhorukov.miroshnikovva.dirindexhtml;

import com.sun.javafx.collections.transformation.SortedList;

import java.io.File;
import java.util.List;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 13.07.13
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
public class DirHtmlGenerator {

    public String getHomeDir() {
        return homeDir;
    }

    /**
     * Проверяет, что файл является дочерним от родительской дирректории
     * или самой родительской директорией
     * @param file
     * @return
     */
    public boolean isChildren(File file){
        File home = new File(homeDir);
        String h = home.getAbsolutePath();
        while (file!=null)   {
            String p = file.getAbsolutePath();
            file = file.getParentFile();
            if (h.equals(p)) {
                return true;
            }
        }
        return false;
    }

    String homeDir;



    public DirHtmlGenerator(String homeDir) {
        this.homeDir = homeDir;
    }

    public String generateHtml(String directory) throws Http404Exception {
        directory = "." + directory;
        if (directory.isEmpty()) directory = ".";
        directory = homeDir + "/" + directory;
        File F = new File(directory);
        if (!F.exists()) {
            System.out.println("Неизвестная директория или файл: " + directory);
            throw new Http404Exception();
        }
        File[] fList = F.listFiles();
        TreeSet<ElementOfTheFileSystemView> set = new TreeSet<>();
        for(int i=0; i<fList.length; i++) {
            ElementOfTheFileSystemView element;
            if (fList[i].isDirectory()) {
                element = new DirView(fList[i]);
            }
            else  {
                element = new FileView(fList[i]);
            }
            set.add(element);
        }
        set.add(new ParentDirView(F.getParentFile()));
        StringBuilder builder = new StringBuilder();
        return printHtml(set, builder);

    }

    String printHtml(Iterable<ElementOfTheFileSystemView> array, StringBuilder builder) {
        builder.append("<html><title>HTTP Server</title>\n"); //<body>Hello <b>world</b></body></html>
        builder.append("    <body>\n");
        for (ElementOfTheFileSystemView element : array) {
            builder.append("        ");
            element.print(builder);
            builder.append("<br>\n");
        }
        builder.append("    </body>\n");
        builder.append("</html>\n");
        return builder.toString();

        //URLEncoder, URLDecoder UTF-8 // В URL пробел можно заменить на + , а они не умеют
    }
}
