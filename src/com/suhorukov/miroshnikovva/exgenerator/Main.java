package com.suhorukov.miroshnikovva.exgenerator;

/**
 * Клас дял работы с исключениями
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Поехали");
        ExceptionGenerator generator = new SimpleExceptionGenerator();
        try{
            generator.generateClassCastException();
        }
        catch (ClassCastException ex) {
              ex.printStackTrace(System.out);
        }

        try{
            generator.generateMyException("Hello");
        }
        catch (MyException ex) {
            ex.printStackTrace(System.out);
        }

        try{
            generator.generateNullPointerException();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace(System.out);
        }

        try{
            generator.generateNumberFormatException();
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace(System.out);
        }

        try{
            generator.generateOutOfMemoryError();
        }
        catch (OutOfMemoryError ex) {
            ex.printStackTrace(System.out);
        }

        try{
            generator.generateStackOverflowError();
        }
        catch (StackOverflowError ex) {
            System.out.println(((SimpleExceptionGenerator)generator).stackErCount);
            //ex.printStackTrace(System.out);
        }

        System.out.println("Конец");
    }
}
