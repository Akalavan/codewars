package main;

/*
Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.

Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:

Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {

        if (a.length == 0) {
            return a;
        }

        List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> bList = Arrays.stream(b).boxed().collect(Collectors.toList());
        List<Integer> cList = new ArrayList<>();

//        aList.removeAll(bList);
//        return aList.stream().mapToInt(value -> value).toArray();

        for (Integer i :
                aList) {
            if (!bList.contains(i)) {
                cList.add(i);
            }
        }

        return cList.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ArrayDiff.arrayDiff(new int[]{1, 2}, new int[]{1})));
        System.out.println(Arrays.toString(ArrayDiff.arrayDiff(new int [] {1,2,2}, new int[] {1})));
        System.out.println(Arrays.toString(ArrayDiff.arrayDiff(new int [] {1,2,2}, new int[] {2})));
        System.out.println(Arrays.toString(ArrayDiff.arrayDiff(new int [] {1,2,2}, new int[] {})));
        System.out.println(Arrays.toString(ArrayDiff.arrayDiff(new int [] {}, new int[] {1,2})));
    }
}
