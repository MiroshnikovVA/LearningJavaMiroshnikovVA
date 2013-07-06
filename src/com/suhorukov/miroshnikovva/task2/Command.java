package com.suhorukov.miroshnikovva.task2;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Интерфейс, некоторая абстрактная команда
 */
public interface Command {
    /**
     *
     * @param stack Команда принимает стэк и возможно меняет его
     */
    public void execute(Stack<Double> stack, String string, HashMap<String, Double> define) throws IllegalArgumentException, EmptyStackException;
}
