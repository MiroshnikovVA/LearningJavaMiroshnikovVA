package com.suhorukov.miroshnikovva.task2;

import junit.framework.TestCase;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 29.06.13
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class CalcTest extends TestCase {

    private BufferedReader BufferedReaderFromResurs(String name) throws UnsupportedEncodingException {
        InputStream stream = getClass().getResourceAsStream("com/suhorukov/miroshnikovva/task2/X1");
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        return br;
    }

    private double simpleCalcFromFile(String fileName)
    {
        InputStream stream = getClass().getResourceAsStream(fileName);
        Calc calc = new Calc();
        calc.run(stream);
        return calc.getRezult();
    }

    public void test1() throws UnsupportedEncodingException {
        assertEquals(simpleCalcFromFile("test1.txt"), 10.0,  1.e-6);
    }

    public void test2() throws UnsupportedEncodingException {
        assertEquals(simpleCalcFromFile("test2.txt"), 20.0,  1.e-6);
    }

    public void testQuadraticEquation1() throws IOException {
        quadraticEquation(1,0,-9);
        quadraticEquation(3,1,-20);
        quadraticEquation(2,2,-6);
        quadraticEquation(1,1,-6);
    }

    private void quadraticEquation(double a, double b, double c) throws IOException {
        Calc calc = new Calc();
        calc.executeCommand("DEFINE a "+a);
        calc.executeCommand("DEFINE b "+b);
        calc.executeCommand("DEFINE c "+c);
        try (InputStream stream = getClass().getResourceAsStream("X1.txt"))
        {
            calc.run(stream);
        }
        double x1 = calc.getRezult();
        try (InputStream stream = getClass().getResourceAsStream("X2.txt"))
        {
            calc.run(stream);
        }
        double x2 = calc.getRezult();
        assertEquals(a*x1*x1 + b*x1 + c, 0.0,  1.e-6);
        assertEquals(a*x2*x2 + b*x2 + c, 0.0,  1.e-6);
    }


}
