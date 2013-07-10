package com.suhorukov.miroshnikovva.task2;

import com.suhorukov.miroshnikovva.task2.annotations.CalculatorContext;
import com.suhorukov.miroshnikovva.task2.annotations.CommandQuery;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
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

    public CommandsFactory(CalculatorContext context) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
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
            while (cls!=Object.class) {
                Field[] fields = cls.getDeclaredFields();
                for (Field f : fields){
                    CommandQuery anno = f.getAnnotation(CommandQuery.class);
                    if (anno!=null){
                        f.setAccessible(true);
                        switch (anno.fields()){
                            case DEFINE_FIELD:
                                f.set(obj, context.define());
                                break;
                            case STACK_FIELD:
                                f.set(obj, context.stack());
                                break;
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
        }
    }

    public Command getCommandFromUserString(String comName) {
            return dic.get(comName);
    }

    private HashMap<String,Command> dic;
}
