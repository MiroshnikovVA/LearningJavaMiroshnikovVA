package com.suhorukov.miroshnikovva.dirindexhtml;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Time;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 13.07.13
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
class FileView extends ElementOfTheFileSystemView {

    private File file;

    public FileView(File file) {
        super();
        this.file = file;
    }

    @Override
    protected int getCompareValue() {
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected int getCompareValue(ElementOfTheFileSystemView element) {
        return file.compareTo(((FileView)element).file);
    }

    @Override
    public void print(StringBuilder stream) {
        long l = file.length();
        String size = l>1024*10?file.length()/1024 + " кбайт":file.length() + " байт";
        String name = file.getName();
        stream.append("<a href=\"");
        stream.append(name);
        stream.append("\">");
        stream.append(name);
        stream.append("</a>");
        stream.append("  ");
        stream.append(size);
        stream.append("  ");
        stream.append(new Date(file.lastModified()));
    }
}
