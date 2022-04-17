package main;

/*
Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.

Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case


 */

import java.util.Arrays;
import java.util.List;

public class BitCounting {
    public static int countBits(int n){
        String bits = Integer.toBinaryString(n);
        return bits.replaceAll("0", "").length();
        //return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1234, 4, 7, 9, 10);

        for (Integer i:
             list) {
            System.out.println(countBits(i));
        }


    }
}
