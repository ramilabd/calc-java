package com.parsing;

import java.util.HashMap;

public class Parser {

    byte firstOperand;
    byte secondOperand;
    char operator;


    public Expression parse(String expression, String pattern) throws Exception {
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
        }

        String[] parts = expression.split("[\\+|\\-|\\*|\\/]");

        if (pattern.equals("PATTERN_ARABIC")) {
            firstOperand = (byte) Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
            secondOperand = (byte) Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
        } else if (pattern.equals("PATTERN_ROMAN")) {
            HashMap<String, Integer> numberRoman = new HashMap<String, Integer>();
            numberRoman.put("I", 1);
            numberRoman.put("II", 2);
            numberRoman.put("III", 3);
            numberRoman.put("IV", 4);
            numberRoman.put("V", 5);
            numberRoman.put("VI", 6);
            numberRoman.put("VII", 7);
            numberRoman.put("VIII", 8);
            numberRoman.put("IX", 9);
            numberRoman.put("X", 10);

            String key0 = parts[0].replaceAll("[^\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\b]", "");
            firstOperand = numberRoman.get(key0).byteValue();

            String key1 = parts[1].replaceAll("[^\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\b]", "");
            secondOperand = numberRoman.get(key1).byteValue();

            if (firstOperand < secondOperand && operator == '-') {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
        }
        return new Expression(firstOperand, secondOperand, operator);
    }
}
