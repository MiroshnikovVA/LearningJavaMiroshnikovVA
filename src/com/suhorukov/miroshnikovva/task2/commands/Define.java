package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 27.06.13
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class Define implements Command {
    @Override
    public void execute(Stack<Double> stack, String string, HashMap<String, Double> define) {
        String[] args = string.split(" ");
        if (args.length!=3)
        {
            throw new IllegalArgumentException("Строка имела неверный формат");
        }

        try
        {
            Double num = new Double(args[2]);
            define.put(args[1],num);
        }
        catch (NumberFormatException excep)
        {
            throw new IllegalArgumentException("Строка имела неверный формат", excep);
        }
    }
}
