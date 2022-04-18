package main;

/*
Сделал очень плохо

Snail Sort
Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]
This image will illustrate things more clearly:


NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array in a clockwise snailshell pattern.

NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
 */


import java.util.Arrays;

public class Snail {

    public static int[] snail(int[][] array) {

//        System.out.println(Arrays.deepToString(array));
        int[] mas = new int[array.length * array.length];

        if (array.length == 0 ||array[0].length == 0)
            return new int[0];


        int k = 0;
        int j = 0;
        int circle = 0;
        int stolb = 0;
        while (k < array.length * array.length) {
            for (int i = circle; i < array.length - j; i++) {
                if (k > array.length * array.length) break;
                mas[k++] = array[circle][i];
            }
            circle++;

            for (int i = circle; i < array.length - j; i++) {
                if (k > array.length * array.length) break;
                mas[k++] = array[i][array.length - circle];
            }

            for (int i = array.length - circle - 1; i >= j; i--) {
                if (k > array.length * array.length) break;
                mas[k++] = array[array.length - circle][i];
            }
            j++;
            for (int i = array.length - circle - 1; i >= j; i--) {
                if (k > array.length * array.length) break;
                mas[k++] = array[i][stolb];
            }
            stolb++;
        }

        return mas;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        int[][] array1 = {{1, 2, 3, 4},
                         {4, 5, 6, 5},
                         {7, 8, 9, 6},
                         {12, 11, 10, 8}};

        int[][] array2 = {{}};
        System.out.println(Arrays.toString(snail(array2)));
    }

}
