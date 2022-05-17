package com.engine;

import com.parsing.Expression;
import com.parsing.Parser;
import com.validate.InputOutput;
import com.validate.Validate;

public class Engine {

    final String PATTERN_ARABIC = "\\s*(10|[0-9])\\s*(\\+|\\-|\\*|\\/)\\s*(10|[0-9])\\s*";
    final String PATTERN_ROMAN = "\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*(\\+|\\-|\\*|\\/)\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*";
    Expression cleared_expression;
    InputOutput io = new InputOutput();
    Validate validate = new Validate(PATTERN_ARABIC, PATTERN_ROMAN);
    Parser parser = new Parser();

    public void start() {
        byte result = 0;
        String expression = "";

        while (!expression.equals("q")) {
            expression = io.getExpression();

            if (validate.isMatchesTemplateArabic(expression)) {
                cleared_expression = parser.parse(expression, "arabic");
            } else if (validate.isMatchesTemplateRoman(expression)) {
                cleared_expression = parser.parse(expression, "roman");
            }

            byte firstOperator = cleared_expression.getFirstOperand();
            byte secondOperator = cleared_expression.getSecondOperand();
            char operator = cleared_expression.getOperator();

            switch (operator) {
                case '+' -> result = (byte) (Math.addExact(firstOperator, secondOperator));
                case '-' -> result = (byte) (Math.subtractExact(firstOperator, secondOperator));
                case '*' -> result = (byte) (Math.multiplyExact(firstOperator, secondOperator));
                case '/' -> result = (byte) (Math.floorDiv(firstOperator, secondOperator));
            }

            io.displayResult(result);
        }
    }
}
