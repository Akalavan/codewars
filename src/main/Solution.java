package main;

/*
Complete the solution so that the function will break up camel casing, using a space between words.

Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static String camelCase(String input) {

        return input
                .chars()
                .mapToObj(ch -> Character.isUpperCase(ch) ? " " + String.valueOf((char) ch) : String.valueOf((char) ch))
                .collect(Collectors.joining());
        //return input.replaceAll("([A-Z])", " $1");

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("camelCasing", "camelCasingTest", "camelcasingtest");

        for (String s :
                list) {
            System.out.println(Solution.camelCase(s));
        }

    }
}
