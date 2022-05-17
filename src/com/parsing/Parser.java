package com.parsing;

import java.util.HashMap;

public class Parser {

    byte firstOperand;
    byte secondOperand;
    char operator;


    public Expression parse(String expression, String numberSystem) {
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

        if (numberSystem.equals("arabic")) {
            firstOperand = (byte) Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
            secondOperand = (byte) Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
        } else if (numberSystem.equals("roman")) {
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
            System.out.println("key1 " + key0);
            firstOperand = numberRoman.get(key0).byteValue();

            String key1 = parts[1].replaceAll("[^\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\b]", "");
            System.out.println("key1 " + key1);
            secondOperand = numberRoman.get(key1).byteValue();
        }
        return new Expression(firstOperand, secondOperand, operator);
    }
}
