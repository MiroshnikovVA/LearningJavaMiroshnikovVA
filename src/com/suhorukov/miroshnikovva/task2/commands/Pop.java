package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;
import com.suhorukov.miroshnikovva.task2.annotations.CommandFild;
import com.suhorukov.miroshnikovva.task2.annotations.CommandQuery;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Команда забирает элемент из стэка
 */
public class Pop implements Command {

    @CommandQuery( fields = CommandFild.STACK_FIELD)
    private Stack<Double> stack = null;

    /**
     * @exception IllegalArgumentException Строка не должна иметь аргументов
     * @exception EmptyStackException Стэк пустой
     */
    @Override
    public void execute(String[] args) {
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
