package com.suhorukov.miroshnikovva.dirindexhtml;

import java.io.File;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 13.07.13
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public class ParentDirView extends ElementOfTheFileSystemView {

    File parentFile;

    public ParentDirView(File parentFile) {
        super();
        this.parentFile = parentFile;
    }

    @Override
    protected int getCompareValue() {
        return -2;
    }

    @Override
    protected int getCompareValue(ElementOfTheFileSystemView element) {
        return 0;
    }

    @Override
    public void print(StringBuilder stream) {
        stream.append("<b><a href=\"");
        stream.append("..");
        stream.append("\">");
        stream.append("..");
        stream.append("</a></b>");
    }
}
