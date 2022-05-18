package com.engine;

import com.calculator.Calculator;
import com.parsing.Expression;
import com.parsing.Parser;
import com.validate.InputOutput;
import com.validate.Validate;

public class Engine {

    Expression cleared_expression;
    InputOutput io = new InputOutput();
    Validate validate = new Validate();
    Parser parser = new Parser();
    Calculator calculator = new Calculator();

    public void start() throws Exception {
        String expression = "";

        while (!expression.equals("q")) {
            expression = io.getExpression();

            String pattern = validate.validator(expression);

            cleared_expression = parser.parse(expression, pattern);
            String result = calculator.calculate(cleared_expression, pattern);

            io.displayResult(result);
        }
    }
}
