package com.suhorukov.miroshnikovva.exgenerator;

import java.util.HashSet;

/**
 * Реализация интерфейса ExceptionGenerator
 */
public class SimpleExceptionGenerator implements ExceptionGenerator {
    @Override
    public void generateNullPointerException() {
        //To change body of implemented methods use File | Settings | File Templates.
        String s = null;
        System.out.println(s.length());
    }

    @Override
    public void generateClassCastException() {
        Object obj = "Множество";
        ((HashSet<Integer>)obj).size();
    }

    @Override
    public void generateNumberFormatException() {
        int i = Integer.parseInt("стопятьсот");
    }

    @Override
    public void generateStackOverflowError() {
        stackErCount++;
        generateStackOverflowError();
    }

    int stackErCount = 0;

    @Override
    public void generateOutOfMemoryError() {
        int[] array = new int[1000000000];
        array[0]=1;
    }

    @Override
    public void generateMyException(String message) throws MyException {
        throw new MyException(message);
    }
}
