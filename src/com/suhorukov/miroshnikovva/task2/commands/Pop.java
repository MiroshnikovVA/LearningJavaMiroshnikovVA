package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Команда забирает элемент из стэка
 */
public class Pop implements Command {

    /**
     *
     * @param stack Команда принимает стэк и меняет его
     * @param string
     *
     * @exception IllegalArgumentException Строка не должна иметь аргументов
     * @exception EmptyStackException Стэк пустой
     */
    @Override
    public void execute(Stack<Double> stack, String string, HashMap<String, Double> define) {
        String[] args = string.split(" ");
        if (args.length!=1)
        {
            throw new IllegalArgumentException("Строка имела неверный формат");
        }

        try
        {
            Double num = stack.pop();
        }
        catch (EmptyStackException excep)
        {
            throw excep;
        }
    }
}
