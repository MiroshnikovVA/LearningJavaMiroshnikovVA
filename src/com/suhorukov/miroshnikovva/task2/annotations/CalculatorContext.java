package com.suhorukov.miroshnikovva.task2.annotations;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 06.07.13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public interface CalculatorContext {
    Stack<Double> stack();
    Map<String, Double> define();
}
