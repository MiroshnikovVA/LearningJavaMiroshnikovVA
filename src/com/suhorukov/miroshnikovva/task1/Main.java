package com.suhorukov.miroshnikovva.task1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 26.06.13
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */

//extends AbstractMap implements Enumeration
public class Main  {
    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt(100);
        System.out.println("Угадайте случайное число от 0 до 99");
        Scanner scanner = new Scanner(System.in);
        int q = -1;
        for (int i = 1; i < 6; i++) {
            System.out.print("Попытка " + i + " : ");
            q = scanner.nextInt();
            if (num > q) {
                System.out.println("Результат больше");
            } else if (num < q) {
                System.out.println("Результат меньше");
            } else {
                break;
            }
        }
        if (num == q) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Вы лузер! Ответ: " + num);
        }
    }

}
