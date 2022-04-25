package main;

/*
In this example you need to implement a function that sort a list of integers based on it's binary representation.

The rules are simple:

    sort the list based on the amount of 1's in the binary representation of each number.
    if two numbers have the same amount of 1's, the shorter string goes first. (ex: "11" goes before "101" when sorting 3 and 5 respectively)
    if the strings have the same length, lower decimal number goes first. (ex: 21 = "10101" and 25 = "11001", then 21 goes first as is lower)

Examples:

    Input: [1,15,5,7,3]
        ( in binary strings is: ["1", "1111", "101", "111", "11"])

    Output: [15, 7, 3, 5, 1]
        (and after sortByBinaryOnes is: ["1111", "111", "11", "101", "1"])
 */


import java.util.Arrays;
import java.util.Comparator;

public class SortByBinaryOnes {

    public static Integer[] sort(Integer[] list) {
        //Write your code
//        int max = 0;
//
//        for (int i = 0; i < list.length - 1; i++) {
//            max = i;
//            for (int j = i + 1; j < list.length; j++) {
//
//                int count1 = Integer.bitCount(list[max]);
//                int count2 = Integer.bitCount(list[j]);
//
//                if (count1 == count2) {
//                    if (Integer.toBinaryString(list[max]).length() > Integer.toBinaryString(list[j]).length()) {
//                        max = j;
//                    } else if (Integer.toBinaryString(list[max]).length() == Integer.toBinaryString(list[j]).length()) {
//                        if (list[max] > list[j]) {
//                            max = j;
//                        }
//                    }
//                } else if (count1 < count2) {
//                    max = j;
//                }
//
//
//            }
//            int tmp = list[i];
//            list[i] = list[max];
//            list[max] = tmp;
//
//        }

        Arrays.sort(list, Comparator.comparingInt(Integer::bitCount).reversed().thenComparing(x -> x));

        return (list);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new Integer[]{1,15,5,7,3})));
    }

}
