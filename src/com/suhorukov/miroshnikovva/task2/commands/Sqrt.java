package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 27.06.13
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class Sqrt implements Command {
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
            num = Math.sqrt(num);
            stack.push(num);
        }
        catch (EmptyStackException excep)
        {
            throw excep;
        }
    }
}
