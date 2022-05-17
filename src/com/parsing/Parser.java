package com.parsing;

import com.parsing.Expression;
import java.util.ArrayList;


public class Parser {
    byte firstOperand;
    byte secondOperand;
    char operator;

    public Expression parse(String expression) {

        for (byte i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            switch (character) {
                case '+':
                case '-':
                case '*':
                case '/':
                    operator = character;
                    break;
            }

            String[] parts = expression.split("[\\+|\\-|\\*|\\/]");
            firstOperand =  (byte) Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
            secondOperand =  (byte) Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
        }

        return new Expression(firstOperand, secondOperand, operator);
    }

}
