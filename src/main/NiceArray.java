package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NiceArray {

    public static boolean isNice(Integer[] arr){
//        boolean isNice = false;
//        for (Integer x1: arr) {
//            for (Integer x2 : arr) {
//                if (x1 == x2 + 1 || x1 == x2 - 1) {
//                    isNice = true;
//                    break;
//                } else {
//                    isNice = false;
//                }
//            }
//            if (!isNice) {
//                return false;
//            }
//        }
//        return isNice;

//        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
//        for (Integer i :
//                set) {
//            if (!set.contains(i + 1) && !set.contains(i - 1)) {
//                return false;
//            }
//        }
//
//        return !set.isEmpty();

//        return Arrays.stream(arr)
//                .filter(i -> Arrays.asList(arr).contains(i + 1) || Arrays.asList(arr).contains(i - 1))
//                .count() == arr.length && arr.length > 1;

        if (arr == null || arr.length == 0) {
            return false;
        }

        return Arrays.stream(arr).allMatch(i -> Arrays.asList(arr).contains(i + 1) || Arrays.asList(arr).contains(i - 1));
    }

    public static void main(String[] args) {
        System.out.println(NiceArray.isNice(new Integer[]{1,2,3,4,5}));
        System.out.println(NiceArray.isNice(new Integer[]{5,4,3,2,1}));
        System.out.println(NiceArray.isNice(new Integer[]{1,3,5,2}));
        System.out.println(NiceArray.isNice(new Integer[]{10,10,2,2,3}));
        System.out.println(NiceArray.isNice(new Integer[]{}));
        System.out.println(NiceArray.isNice(new Integer[]{1}));
    }
}
