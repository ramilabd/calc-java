package com.validate;

import java.util.Scanner;

public class InputOutput {

    public static String getExpression() {
        System.out.print("Ввод: ");

        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void displayResult(String result) {
        System.out.println("Результат: " + result);
    }
}
