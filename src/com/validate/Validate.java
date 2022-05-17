package com.validate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Validate {

    String patternArabic;
    String patternRoman;

    public Validate(String patternArabic, String patternRoman){
        this.patternArabic = patternArabic;
        this.patternRoman = patternRoman;
    }

    public boolean isMatchesTemplateArabic(String input) {
        Pattern numArabic = Pattern.compile(patternArabic);
        Matcher matcherArabic = numArabic.matcher(input);

        return matcherArabic.matches();
    }

    public boolean isMatchesTemplateRoman(String input) {
        Pattern numRoman = Pattern.compile(patternRoman);
        Matcher matcherRoman = numRoman.matcher(input);

        return matcherRoman.matches();
    }

}
