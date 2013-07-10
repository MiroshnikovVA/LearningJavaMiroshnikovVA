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
     *
     */
    public void execute(String[] args) throws IllegalArgumentException, EmptyStackException;
}
