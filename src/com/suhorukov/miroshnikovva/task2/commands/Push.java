package com.suhorukov.miroshnikovva.task2.commands;

import com.suhorukov.miroshnikovva.task2.Command;

import java.util.HashMap;
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

    /**
     *
     * @param stack Команда принимает стэк и меняет его
     * @param string
     *
     * @exception IllegalArgumentException Строка имела неверный формат
     */
    @Override
    public void execute(Stack<Double> stack, String string, HashMap<String, Double> define) {
        String[] args = string.split(" ");
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
