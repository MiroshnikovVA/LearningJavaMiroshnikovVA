package com.suhorukov.miroshnikovva.exgenerator;

/**
 * пример собственного класса исключения
 */
public class MyException extends Exception {
    public MyException(String message){
        super(message);
    }
}
