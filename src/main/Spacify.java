package main;

/*
Modify the spacify function so that it returns the given string with spaces inserted between each character.

spacify("hello world") // returns "h e l l o   w o r l d"

 */

import java.util.stream.Collectors;

public class Spacify {

    public static String spacify(String str){
       // return str.replaceAll("", " ").trim();
        return str.chars().mapToObj(i -> (char)i + " ").collect(Collectors.joining()).trim(); //show me the code!
    }

    public static void main(String[] args) {
        System.out.println(spacify("hello world"));
    }
}
