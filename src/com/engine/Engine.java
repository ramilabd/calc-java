package com.engine;

import com.calculator.Calculator;
import com.parsing.Expression;
import com.parsing.Parser;
import com.validate.InputOutput;
import com.validate.Validate;

public class Engine {

    Expression cleared_expression;
    Validate validate = new Validate();
    Parser parser = new Parser();
    Calculator calculator = new Calculator();

    public void start() throws Exception {

        String expression = InputOutput.getExpression();

        while (!expression.equals("q")) {
            String pattern = validate.validator(expression);
            cleared_expression = parser.parse(expression, pattern);
            String result = calculator.calculate(cleared_expression, pattern);
            InputOutput.displayResult(result);

            expression = InputOutput.getExpression();
        }

        System.out.println("Программа завершена.");
        System.exit(0);
    }
}
