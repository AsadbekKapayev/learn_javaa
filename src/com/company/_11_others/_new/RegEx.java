package com.company._11_others._new;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

    public static void main(String[] args) {

        //region 1
        String text = "Hello world!";

        // first
        {
            Pattern pattern = Pattern.compile("^He");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

        // last
        {
            Pattern pattern = Pattern.compile("ld!$");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

        {
            Pattern pattern = Pattern.compile("\\bworld\\b"); // без !
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

        {
            Pattern pattern = Pattern.compile("\\Bel\\B");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
        //endregion

        //region Matches & split
        {
            String value = "Hello world";

            if (value.matches("Hello world")) {
                System.out.println(value);
            }
        }

        {
            String value = "Hello, world, today, I, am, good";
            String[] split = value.split(", ");

            System.out.println(Arrays.toString(split));
        }
        //endregion

        //region replaceAll & group
        {
            String value = "Hello, world, today, I, am, good";
            value = value.replaceAll(",", ";");

            System.out.println(value);
        }
        //endregion
    }


}
