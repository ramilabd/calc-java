package com.calculator;

import com.parsing.Expression;

public class Calculator {

    public String calculate(Expression expression, String pattern) {
        int result = 0;

        byte firstOperator = expression.getFirstOperand();
        byte secondOperator = expression.getSecondOperand();
        char operator = expression.getOperator();

        switch (operator) {
            case '+':
                result = (Math.addExact(firstOperator, secondOperator));
                break;
            case '-':
                result = (Math.subtractExact(firstOperator, secondOperator));
                break;
            case '*':
                result = (Math.multiplyExact(firstOperator, secondOperator));
                break;
            case '/':
                result = (Math.floorDiv(firstOperator, secondOperator));
                break;
        }

        if (pattern.equals("PATTERN_ROMAN")) {
            return NumberRoman.toRoman(result);
        }
        return Integer.toString(result);
    }
}
