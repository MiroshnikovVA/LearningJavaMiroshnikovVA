package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;
import com.suhorukov.miroshnikovva.task2.annotations.CommandFild;
import com.suhorukov.miroshnikovva.task2.annotations.CommandQuery;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Общий абстрактный класс для бинарных команд
 */
public abstract class BinOperator implements Command {

    protected abstract double getResult(double num1, double num2);

    @CommandQuery( fields = CommandFild.STACK_FIELD)
    private Stack<Double> stack = null;

    @Override
    public void execute(String[] args) {
        if (args.length!=1)
        {
            throw new IllegalArgumentException("Строка имела неверный формат");
        }

        if (stack.size()<2)
        {
            throw new EmptyStackException();
        }

        Double num1 = stack.pop();
        Double num2 = stack.pop();
        stack.push(getResult(num2, num1));
    }
}
