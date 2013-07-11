package com.suhorukov.miroshnikovva.exgenerator;

/**
 * Интерфейс генерирующий исключения
 */
public interface ExceptionGenerator {
    void generateNullPointerException();
    void generateClassCastException();
    void generateNumberFormatException();
    void generateStackOverflowError();
    void generateOutOfMemoryError();
    void generateMyException(String message) throws MyException;
}
