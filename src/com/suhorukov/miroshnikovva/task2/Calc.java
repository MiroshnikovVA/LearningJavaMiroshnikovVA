package com.suhorukov.miroshnikovva.task2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 29.06.13
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class Calc {

    CommandsFactory factory;
    Stack<Double> stack = new Stack<Double>();

    HashMap<String, Double> define = new HashMap<String, Double>();

    public Calc() {
        try {
            factory = new CommandsFactory();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void run(InputStream in){
        if (factory == null)
        {
            System.out.println("Не получается загрузить команды");
            return;
        }
        Scanner scanner = new Scanner(in);
        while (true) {
            System.out.println("Введите команду:");
            String userString = scanner.nextLine();
            if ("EXIT".equals(userString)) {
                System.out.println("Выход");
                return;
            }
            executeCommand(userString);
        }
    }

    public void executeCommand(String userString){
        System.out.println("Выполняем: " + userString);
        Command com = factory.getCommandFromUserString(userString);
        if (com!=null)
        {   try
        {
            com.execute(stack, userString, define);
        }
        catch (Exception excep)
        {
            System.out.println(excep.getMessage());
        }
        }
        else
        {
            System.out.println("Неизвестная команда");
        }
    }

    public double getRezult(){
        return stack.peek();
    }

}
