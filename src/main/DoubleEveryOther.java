package main;

/*
Write a function that doubles every second integer in a list, starting from the left.

Example:

For input array/list :

[1,2,3,4]

the function should return :

[1,4,3,8]


 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class DoubleEveryOther {

    public static int[] doubleEveryOther(int[] a){

//        IntStream.iterate(1, i -> i < a.length, i -> i += 2).forEach(i -> a[i] *= 2);
//        return a;

        return IntStream.range(0, a.length).map(i -> {
            if (i % 2 != 0) {
                a[i] *= 2;
            }
            return a[i];
        }).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(doubleEveryOther(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(doubleEveryOther(new int[]{1,19,6,2,12,-3})));
        System.out.println(Arrays.toString(doubleEveryOther(new int[]{-1000,1653,210,0,1})));
    }
}
