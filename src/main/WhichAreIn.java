package main;

/*
Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
Example 1:

a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]
Example 2:

a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []
Notes:

    Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
    In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
    Beware: r must be without duplicates.


 */

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;
import java.util.stream.Collector;

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {

        TreeSet<String> result = new TreeSet<>();

        Arrays.stream(array2)
                .forEach(s -> Arrays.stream(array1)
                        .filter(s::contains).forEach(result::add));

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
//        String a[] = new String[]{"arp", "live", "strong"};
//        String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
//        System.out.println(Arrays.toString(inArray(a, b)));

        String a[] = new String[]{"cod", "code", "wars", "ewar", "pillow", "bed", "phht"};
        String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong", "codewars"};
        System.out.println(Arrays.toString(inArray(a, b)));

        a = new String[]{"cod", "code", "wars", "ewar", "ar"};
        b = new String[]{"lively", "alive", "harp", "sharp", "armstrong", "codewars"};
        System.out.println(Arrays.toString(inArray(a, b)));
    }
}
