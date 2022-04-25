package main;

/*
In this kata you need to create a function that takes a 2D array/list of non-negative integer pairs
and returns the sum of all the "saving" that you can have getting the LCM of each couple of number compared to their simple product.

For example, if you are given:

[[15,18], [4,5], [12,60]]

Their product would be:

[270, 20, 720]

While their respective LCM would be:

[90, 20, 60]

Thus the result should be:

(270-90)+(20-20)+(720-60)==840

 */

import java.util.stream.IntStream;

public class Solution1 {
    public static int sumDifferencesBetweenProductsAndLCMs(final int[][] pairs) {

        int a = 0;
        int b = 0;

        int[] nok = new int[pairs.length];
        int[] multi = new int[pairs.length];

        for (int i = 0; i < pairs.length; i++) {
            a = pairs[i][0];
            b = pairs[i][1];

            multi[i] = a * b;
            nok[i] = NOK(a, b, NOD(a, b));
        }

        return IntStream.range(0, nok.length).map(i -> multi[i] - nok[i]).sum();
    }

    private static int NOK(int a, int b, int nod) {
        return nod > 0 ? a * b / nod : 0;
    }

    private static int NOD(int a, int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(sumDifferencesBetweenProductsAndLCMs(new int[][]{{15,18}, {4,5}, {12,60}}));
        System.out.println(sumDifferencesBetweenProductsAndLCMs(new int[][]{{1,1}, {0,0}, {13,91}}));
        System.out.println(sumDifferencesBetweenProductsAndLCMs(new int[][]{{15,7}, {4,5}, {19,60}}));
        System.out.println(sumDifferencesBetweenProductsAndLCMs(new int[][]{{20,50}, {10,10}, {50,20}}));
    }
}
