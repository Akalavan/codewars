package main;
/*

Don't give me five!

In this kata you get the start number and the end number of a region and should return the count of all numbers except numbers with a 5 in it.
 The start and the end number are both inclusive!

Examples:

1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12

The result may contain fives. ;-)
The start number will always be smaller than the end number. Both numbers can be also negative!

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class DontGiveMeFive {
    public static int dontGiveMeFive(int start, int end) {

        //return (int) IntStream.rangeClosed(start, end).filter(codePoint -> String.valueOf(codePoint).chars().allMatch(c -> c != 53)).count();
        //return (int) IntStream.rangeClosed(start, end).filter(i -> !("" + i).contains("5")).count();
        return (int) IntStream.rangeClosed(start, end).filter(i -> String.valueOf(i).indexOf('5') == -1).count();

    }

    public static void main(String[] args) {
        DontGiveMeFive.dontGiveMeFive(1, 9);
        System.out.println(DontGiveMeFive.dontGiveMeFive(1, 9));
        System.out.println(DontGiveMeFive.dontGiveMeFive(4, 17));

        System.out.println(DontGiveMeFive.dontGiveMeFive(1, 90));
    }
}
