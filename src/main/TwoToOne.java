package main;

/*
Take 2 strings s1 and s2 including only letters from ato z.
Return a new sorted string, the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.

Examples:
a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 */

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoToOne {

    public static String longest (String s1, String s2) {
        String all = s1 + s2;

        Set<String> set = new TreeSet<>(Arrays.asList(all.split("")));

        StringBuilder newStr = new StringBuilder();

        for (String s :
                set) {
            newStr.append(s);
        }

        return newStr.toString();
//        StringBuilder sb = new StringBuilder();
//        s1.concat(s2).chars().distinct().sorted().forEach(c -> sb.append((char) c));
//        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(TwoToOne.longest("aretheyhere", "yestheyarehere"));
        System.out.println(TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        System.out.println(TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
    }
}
