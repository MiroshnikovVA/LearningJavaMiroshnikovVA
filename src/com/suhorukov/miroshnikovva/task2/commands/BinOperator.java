package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 29.06.13
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 */
public abstract class BinOperator implements Command {

    protected abstract double getResult(double num1, double num2);

    @Override
    public void execute(Stack<Double> stack, String string, HashMap<String, Double> define) {
        String[] args = string.split(" ");
        if (args.length!=1)
        {
            throw new IllegalArgumentException("Строка имела неверный формат");
        }

        try
        {
            Double num1 = stack.pop();
            try
            {
                Double num2 = stack.pop();
                stack.push(getResult(num2, num1));
            }
            catch (EmptyStackException excep)
            {
                stack.push(num1); //Возвращаем исходное состояние
                throw excep;
            }
        }
        catch (EmptyStackException excep)
        {
            throw excep;
        }
    }
}
