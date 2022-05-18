package com.validate;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Validate {

    public String validator(String inputExpression) throws Exception {

        HashMap<String, String> patterns = new HashMap<>();

        patterns.put("PATTERN_ARABIC", "\\s*(10|[0-9])\\s*(\\+|\\-|\\*|\\/)\\s*(10|[0-9])\\s*");
        patterns.put("PATTERN_ROMAN",
            "\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*(\\+|\\-|\\*|\\/)\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*");
        patterns.put("PATTERN_ROM_ARAB",
            "\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*(\\+|\\-|\\*|\\/)\\s*(10|[0-9])\\s*");
        patterns.put("PATTERN_ARAB_ROM",
            "\\s*(10|[0-9])\\s*(\\+|\\-|\\*|\\/)\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*");
        patterns.put("PATTERN_ONE_NUM",
            "\\s*(10|[0-9])|\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*");
        patterns.put("PATTERN_ARABIC_MORE_TWO_NUM",
            "\\s*(10|[0-9])\\s*(\\+|\\-|\\*|\\/)\\s*(10|[0-9])\\s*(\\+|\\-|\\*|\\/)\\s*(10|[0-9])\\s*");
        patterns.put("PATTERN_ROMAN_MORE_TWO_NUM",
            "\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*(\\+|\\-|\\*|\\/)\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*(\\+|\\-|\\*|\\/)\\s*\\b(I|II|III|IV|V|VI|VII|VIII|IX|X)\\b\\s*");
//        patterns.put("ANY_CHARACTER", "[A-Za-z0-9]");
        String result = null;

        for (String key : patterns.keySet()) {
            Pattern pattern = Pattern.compile(patterns.get(key));
            Matcher matcher = pattern.matcher(inputExpression);

            if (matcher.matches()) {
                result = switch (key) {
                    case "PATTERN_ARABIC", "PATTERN_ROMAN" -> key;
                    case "PATTERN_ROM_ARAB", "PATTERN_ARAB_ROM" ->
                        throw new Exception("Используются одновременно разные системы счисления.");
                    case "PATTERN_ONE_NUM" ->
                        throw new Exception("Строка не является математической операцией");
                    case "PATTERN_ARABIC_MORE_TWO_NUM", "PATTERN_ROMAN_MORE_TWO_NUM" ->
                        throw new Exception(
                            "Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    default -> throw new Exception(
                        "Не гоните ерунду :), читайте описание работы калькулятора");
                };
            }
        }
        return result;
    }
}
