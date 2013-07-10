package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;
import com.suhorukov.miroshnikovva.task2.annotations.CommandFild;
import com.suhorukov.miroshnikovva.task2.annotations.CommandQuery;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 27.06.13
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class Sqrt implements Command {

    @CommandQuery( fields = CommandFild.STACK_FIELD)
    private Stack<Double> stack = null;

    @Override
    public void execute(String[] args) {
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
