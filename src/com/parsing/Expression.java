package com.parsing;

public class Expression {
    byte firstOperand;
    byte secondOperand;
    char operator;

    public Expression(byte firstOperand, byte secondOperand, char operator){
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public byte getFirstOperand() {
        return firstOperand;
    }

    public byte getSecondOperand() {
        return secondOperand;
    }

    public char getOperator() {
        return operator;
    }
}
