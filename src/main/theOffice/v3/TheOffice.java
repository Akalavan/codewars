package main.theOffice.v3;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
The bloody photocopier is broken... Just as you were sneaking around the office to print off your favourite binary code!

Instead of copying the original, it reverses it: '1' becomes '0' and vice versa.

Given a string of binary, return the version the photocopier gives you as a string.
 */
public class TheOffice {

    public static String broken(final String x) {
        return Arrays.stream(x.split(""))
                .map(s -> s.equals("0") ? "1" : "0")
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(broken("10000000101101111110011001000"));
    }

}
