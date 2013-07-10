package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;
import com.suhorukov.miroshnikovva.task2.annotations.CommandFild;
import com.suhorukov.miroshnikovva.task2.annotations.CommandQuery;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 26.06.13
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 */


/**
 * Команда впихивает элемент в стэк
 */
public class Push implements Command {

    @CommandQuery( fields = CommandFild.STACK_FIELD)
    private Stack<Double> stack = null;

    @CommandQuery( fields = CommandFild.DEFINE_FIELD)
    private Map<String, Double> define = null;

    /**
     * @exception IllegalArgumentException Строка имела неверный формат
     */
    @Override
    public void execute(String[] args) {
        if (args.length!=2)
        {
             throw new IllegalArgumentException("Строка имела неверный формат");
        }

        try
        {
            Double num = new Double(args[1]);
            stack.push(num);
        }
        catch (NumberFormatException excep) {
            Double num = define.get(args[1]);
            if (num!=null)   {
                stack.push(num);
            }
            else {
                throw new IllegalArgumentException("Строка имела неверный формат", excep);
            }
        }
    }
}
