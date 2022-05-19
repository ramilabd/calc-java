package com.greeting;

public class Greeting {

    static String greeting = """
        Калькулятор.
        Введите математическое выражение вида "{число} {опрартор} {число}"
        Число: арабское или римское, от 0 до 10, от I до X
        Оператор: +, -, *, /
        Для выхода из программы введите: 'q'
        """;

    public static void displayGreeting() {
        System.out.println(greeting);
    }
}
