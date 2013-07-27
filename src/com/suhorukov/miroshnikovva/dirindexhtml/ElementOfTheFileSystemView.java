package com.suhorukov.miroshnikovva.dirindexhtml;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 13.07.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public abstract class ElementOfTheFileSystemView implements Comparable {

    public  ElementOfTheFileSystemView(){
    }

    abstract protected int getCompareValue();

    abstract protected int getCompareValue(ElementOfTheFileSystemView element);

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof ElementOfTheFileSystemView)) return -1;
        ElementOfTheFileSystemView el = (ElementOfTheFileSystemView)o;
        int thisCV = this.getCompareValue();
        int elCV = el.getCompareValue();
        if (thisCV < elCV ) return -1;
        if (thisCV > elCV) return 1;
        return this.getCompareValue(el);
    }

    public abstract void print(StringBuilder stream);
}
