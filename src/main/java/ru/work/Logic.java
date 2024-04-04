package ru.work;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {

    public static List<String> run(String text, String str_pattern) {
        List<String> lst_str = new ArrayList<>();
        Pattern pattern = Pattern.compile(str_pattern);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String s = text.substring(matcher.start(), matcher.end());
            lst_str.add(s);
        }
        return lst_str;
    }
}
