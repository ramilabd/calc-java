package com;

import com.engine.Engine;
import com.greeting.Greeting;


public class Main {

    public static void main(String[] args) throws Exception {
        Greeting.displayGreeting();

        Engine engine = new Engine();
        engine.start();
    }
}
