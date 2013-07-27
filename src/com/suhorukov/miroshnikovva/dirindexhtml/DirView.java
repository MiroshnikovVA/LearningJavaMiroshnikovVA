package com.suhorukov.miroshnikovva.dirindexhtml;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 13.07.13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
class DirView extends ElementOfTheFileSystemView {

    private File file;

    public DirView(File file) {
        super();
        this.file = file;
    }

    @Override
    protected int getCompareValue() {
        return -1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected int getCompareValue(ElementOfTheFileSystemView element) {
        return file.compareTo(((DirView)element).file);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void print(StringBuilder stream) {
        String name = file.getName();
        stream.append("<b><a href=\"");
        try {
            stream.append(URLEncoder.encode(name, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            stream.append(name);
        }
        stream.append("/\">");
        stream.append(name);
        stream.append("/</a></b>");
    }
}
