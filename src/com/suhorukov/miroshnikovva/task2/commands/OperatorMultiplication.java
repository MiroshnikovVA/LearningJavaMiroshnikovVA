package com.suhorukov.miroshnikovva.task2.commands;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 27.06.13
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class OperatorMultiplication extends BinOperator {

    @Override
    protected double getResult(double num1, double num2) {
        return num1*num2;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
