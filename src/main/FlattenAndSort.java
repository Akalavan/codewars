package main;

/*
Challenge:

Given a two-dimensional array of integers, return the flattened version of the array with all the integers in the sorted (ascending) order.

Example:

Given [[3, 2, 1], [4, 6, 5], [], [9, 7, 8]], your function should return [1, 2, 3, 4, 5, 6, 7, 8, 9].

 */

import java.util.*;
import java.util.stream.Collectors;

public class FlattenAndSort {

    public static int[] flattenAndSort(int[][] array) {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> sortedlist = new ArrayList<>();
//        Arrays.stream(array).forEach(arr -> Arrays.stream(arr).sorted().forEach(list::add));
//
//        sortedlist = list.stream().sorted().collect(Collectors.toList());
//
//        int[] mas = new int[sortedlist.size()];
//
//        int i = 0;
//
//        for (Integer integer : sortedlist) {
//            mas[i++] = integer;
//        }
//
//        return mas;

        return Arrays.stream(array).flatMapToInt(Arrays::stream).sorted().toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(FlattenAndSort.flattenAndSort(new int[][]{})));
        System.out.println(Arrays.toString(FlattenAndSort.flattenAndSort(new int[][]{{}, {1}})));
        System.out.println(Arrays.toString(FlattenAndSort.flattenAndSort(new int[][]{{3, 2, 1, 1}, {7, 9, 8}, {6, 4, 5}})));
        System.out.println(Arrays.toString(FlattenAndSort.flattenAndSort(new int[][]{{1, 3, 5} ,{100}, {2, 4, 6}})));
        System.out.println(Arrays.toString(FlattenAndSort.flattenAndSort(new int[][]{{111, 999}, {222}, {333}, {444}, {888}, {777}, {666}, {555}})));

    }

}
