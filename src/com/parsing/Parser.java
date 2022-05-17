package com.parsing;

import com.parsing.Expression;
import java.util.ArrayList;


public class Parser {
    byte firstOperand;
    byte secondOperand;
    char operator;

    public Expression parse(String expression) {

        char[] chars = expression.toCharArray();
        ArrayList<Byte> numbers = new ArrayList<Byte>();

        for (char character : chars){
            if (Character.isDigit(character)) {
                numbers.add((byte) Integer.parseInt(Character.toString(character)));
            }
            switch (character){
                case '+':
                case '-':
                case '*':
                case '/':
                    operator = character;
            }
        }

        firstOperand = numbers.get(0);
        secondOperand = numbers.get(1);

        return new Expression(firstOperand, secondOperand, operator);
    }

}
