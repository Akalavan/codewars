package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Isogram {
    public static boolean  isIsogram(String str) {
        HashMap<String, Integer> words = new HashMap<>();

        if (str == null) {
            return false;
        }

        if (str.length() < 2)  {
            return true;
        }

        for (String s :
                str.split("")) {
            if (words.get(s.toLowerCase()) != null) {
                return false;
            } else {
                words.put(s, 1);
            }
        }
        return true;

        //str.length() == str.toLowerCase().chars().distinct().count();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Dermatoglyphics", "isogram", "moose", "isIsogram", "aba", "moOse", "thumbscrewjapingly", "");

        for (String s :
                list) {
            System.out.println(Isogram.isIsogram(s));
        }
    }
}
