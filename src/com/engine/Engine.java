package com.engine;

import com.parsing.Expression;
import com.parsing.Parser;
import com.validate.InputOutput;
import com.validate.Validate;

public class Engine {


    final String pattern_arabic = "\\s*\\d\\s*(\\+|\\-|\\*|\\/)\\s*\\d\\s*";

    public void start() {
        InputOutput io = new InputOutput();
        Validate validate = new Validate(pattern_arabic);
        Parser parser = new Parser();
        Expression cleared_expression;
        byte result = 0;
        String expression = "";

        while (!expression.equals("q")) {
            expression = io.getExpression();
            if (validate.isMatchesTemplate(expression)) {
                cleared_expression = parser.parse(expression);

                byte firstOperator = cleared_expression.getFirstOperand();
                byte secondOperator = cleared_expression.getSecondOperand();

                switch (cleared_expression.getOperator()) {
                    case '+':
                        result = (byte) (Math.addExact(firstOperator, secondOperator));
                        break;
                    case '-':
                        result = (byte) (Math.subtractExact(firstOperator, secondOperator));
                        break;
                    case '*':
                        result = (byte) (Math.multiplyExact(firstOperator, secondOperator));
                        break;
                    case '/':
                        result = (byte) (Math.floorDiv(firstOperator, secondOperator));
                }

                io.displayResult(result);
            }
        }
    }
}
