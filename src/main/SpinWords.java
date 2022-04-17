package main;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata).
Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.

Examples: spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" spinWords( "This is a test") => returns "This is a test" spinWords( "This is another test" )=> returns "This is rehtona test"
 */


public class SpinWords {

    public String spinWords(String sentence) {

//        return Arrays.stream(sentence.split(" "))
//                .map(s -> s.length() >= 5 ? new StringBuilder(s).reverse().toString() : s)
//                .collect(Collectors.joining(" "));

        return Stream.of(sentence.split(" "))
                .map(s -> {
                    StringBuilder tmp = new StringBuilder();
                    if (s.length() >= 5) {
                        tmp.append(s).reverse();
                    } else {
                        tmp.append(s);
                    }
                    return tmp.toString();
                })
                .collect(Collectors.joining(" ")).trim();

    }

    public static void main(String[] args) {
        System.out.println(new SpinWords().spinWords("Welcome"));
        System.out.println(new SpinWords().spinWords("Hey fellow warriors"));
    }
}
