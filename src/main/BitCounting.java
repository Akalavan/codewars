package main;

import java.util.Arrays;
import java.util.List;

public class BitCounting {
    public static int countBits(int n){
        String bits = Integer.toBinaryString(n);
        return bits.replaceAll("0", "").length();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1234, 4, 7, 9, 10);

        for (Integer i:
             list) {
            System.out.println(countBits(i));
        }


    }
}
