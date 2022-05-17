package com.validate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Validate {

    String pattern_arabic;

    public Validate(String pattern){
        this.pattern_arabic = pattern;
    }

    public boolean isMatchesTemplate(String input) {
        Pattern pattern = Pattern.compile(pattern_arabic);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
