package com.suhorukov.miroshnikovva.task2;

import com.suhorukov.miroshnikovva.task2.Command;
import com.suhorukov.miroshnikovva.task2.commands.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 27.06.13
 * Time: 16:09
 * To change this template use File | Settings | File Templates.
 */
public class CommandsFactory {

    public Command GetCommand(String s) throws IllegalArgumentException {
        String[] args = s.split(" ");
        if (s=="" || s==null)
        {
            throw new IllegalArgumentException("Строка пустая");
        }
        Command com = dic.get(args[0]);
        if (com == null)          {
            throw new IllegalArgumentException("Неизвестная команда " + args[0]);
        }
        return com;
    }

    public CommandsFactory() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties prop = new Properties();
        InputStream stream = getClass().getResourceAsStream("commands/commands.properties");
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        prop.load(reader);
        System.out.println(prop.toString());
        dic = new HashMap<String, Command>();
        for (Object key : prop.keySet())
        {
            String keyStr = key.toString();
            String className = prop.getProperty(keyStr);
            Class cls = Class.forName(className);
            Object obj =  cls.newInstance();
            if (obj instanceof Command)  //Если загрузен нужный класс
            {
                dic.put(keyStr,(Command)obj);
            }
        }
    }

    public Command getCommandFromUserString(String userString) {
        String[] args = userString.split(" ");
        if (args.length>0)
        {
            String com = args[0];
            return dic.get(com);
        }
        return null;
    }

    private HashMap<String,Command> dic;
}
