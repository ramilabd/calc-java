package com.validate;

import java.util.Scanner;

public class InputOutput {

    public String getExpression() {
        Scanner in = new Scanner(System.in);
        String expression;

        System.out.print("Ввод: ");
        expression = in.nextLine();

        if (expression.equals("q")) {
            in.close();
        }

        return expression;
    }

    public void displayResult(String result) {
        System.out.println("Результат: " + result);
    }
}
