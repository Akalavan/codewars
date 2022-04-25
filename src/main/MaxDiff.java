package main;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaxDiff {

    public static int maxDiff(int[] lst) {
        OptionalInt max = IntStream.of(lst).max();
        return max.isPresent() ? max.getAsInt() - IntStream.of(lst).min().getAsInt() : 0;

    }

    public static void main(String[] args) {
        System.out.println(MaxDiff.maxDiff(new int[]{ 1, 2, 3, 4, 5, 5, 4 }));
        System.out.println(MaxDiff.maxDiff(new int[]{  -4, -5, -3, -1, -31  }));
        System.out.println(MaxDiff.maxDiff(new int[]{  1, 2, 3, 4, -5, 5, 4  }));
        System.out.println(MaxDiff.maxDiff(new int[]{  1000000  }));
        System.out.println(MaxDiff.maxDiff(new int[]{}));
    }
}
