package main.playingListArrays.v2;

/*
Task

Given an array/list [] of integers , Find the product of the k maximal numbers.
Notes

    Array/list size is at least 3 .

    Array/list's numbers Will be mixture of positives , negatives and zeros

    Repetition of numbers in the array/list could occur.

Input >> Output Examples

maxProduct ({4, 3, 5}, 2) ==>  return (20)

Explanation:

    Since the size (k) equal 2 , then the subsequence of size 2 whose gives product of maxima is 5 * 4 = 20 .

maxProduct ({8, 10 , 9, 7}, 3) ==>  return (720)

Explanation:

    Since the size (k) equal 3 , then the subsequence of size 3 whose gives product of maxima is 8 * 9 * 10 = 720 .

maxProduct ({10, 8, 3, 2, 1, 4, 10}, 5) ==> return (9600)

Explanation:

    Since the size (k) equal 5 , then the subsequence of size 5 whose gives product of maxima is 10 * 10 * 8 * 4 * 3 = 9600 .

maxProduct ({-4, -27, -15, -6, -1}, 2) ==> return (4)

Explanation:

    Since the size (k) equal 2 , then the subsequence of size 2 whose gives product of maxima is -4 * -1 = 4 .

maxProduct ({10, 3, -1, -27} , 3)  return (-30)

Explanation:

    Since the size (k) equal 3 , then the subsequence of size 3 whose gives product of maxima is 10 * 3 * -1 = -30 .
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.LongStream;

public class Solution {

    public static long maxProduct(int[] numbers, int sub_size)
    {
//        return Arrays.stream(numbers)
//                .sorted()
//                .skip(numbers.length - sub_size)
//                .mapToLong(Long::valueOf)
//                .reduce(1, (x, y) -> x * y);

        Long[] nums = Arrays.stream(numbers).mapToLong(i -> i).boxed().toArray(Long[]::new);
        Arrays.sort(nums, Comparator.reverseOrder());

        return LongStream.iterate(0, i -> i < sub_size, i -> i = i + 1).map(i -> nums[(int) i]).reduce((i, i1) -> i * i1).orElse(1);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{4,3,5}, 2));
        System.out.println(maxProduct(new int[]{10,8,7,9}, 3));
        System.out.println(maxProduct(new int[]{8,6,4,6}, 3));
    }
}
