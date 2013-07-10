package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;
import com.suhorukov.miroshnikovva.task2.annotations.CommandFild;
import com.suhorukov.miroshnikovva.task2.annotations.CommandQuery;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 27.06.13
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class Define implements Command {

    @CommandQuery( fields = CommandFild.DEFINE_FIELD)
    private Map<String, Double> define = null;

    @Override
    public void execute(String[] args) {
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
