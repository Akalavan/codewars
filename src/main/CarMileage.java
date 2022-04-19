package main;

/*
"7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up,
he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?

Let's make it so Bob never misses another interesting number.
We've hacked into his car's computer, and we have a box hooked up that reads mileage numbers.
We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).

It's up to you, intrepid warrior, to glue the parts together.
Write the function that parses the mileage number input, and returns a 2 if the number is "interesting" (see below),
a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.

Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.
"Interesting" Numbers

Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:

    Any digit followed by all zeros: 100, 90000
    Every digit is the same number: 1111
    The digits are sequential, incementing†: 1234
    The digits are sequential, decrementing‡: 4321
    The digits are a palindrome: 1221 or 73837
    The digits match one of the values in the awesomePhrases array

    † For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
    ‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.

So, you should expect these inputs and outputs:

// "boring" numbers
CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

// progress as we near an "interesting" number
CarMileage.isInteresting(11207, new int[]{}); // 0
CarMileage.isInteresting(11208, new int[]{}); // 0
CarMileage.isInteresting(11209, new int[]{}); // 1
CarMileage.isInteresting(11210, new int[]{}); // 1
CarMileage.isInteresting(11211, new int[]{}); // 2

// nearing a provided "awesome phrase"
CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2

Error Checking

    A number is only interesting if it is greater than 99!
    Input will always be an integer greater than 0, and less than 1,000,000,000.
    The awesomePhrases array will always be provided, and will always be an array, but may be empty. (Not everyone thinks numbers spell funny words...)
    You should only ever output 0, 1, or 2.


 */

import java.util.Arrays;

public class CarMileage {
    public static int isInteresting(int number, int[] awesomePhrases) {
        if (number < 100) {
            return 0;
        }

        if (awesomePhrases.length > 0) {
            return checkAwesomePhrase(number, awesomePhrases);
        }

        String[] test = {"allZero", "isPalindrome", "isSequentialDecrementing", "isSequentialIncrementing", "numberIdenticalDigits"};
        boolean accept = false;
        for (int i = 0; i < 2; i++) {
            for (String str :
                    test) {
                switch (str) {
                    case "allZero" :
                        accept = isAllZeros(number);
                        break;
                    case "isPalindrome":
                        accept = isPalindrome(number);
                        break;
                    case "isSequentialDecrementing":
                        accept = isSequential(number, true);
                        break;
                    case "isSequentialIncrementing":
                        accept = isSequential(number, false);
                        break;
                    case "numberIdenticalDigits":
                        accept = numberIdenticalDigits(number);
                        break;
                }
            }
        }
        return 0;
    }

    private static boolean isAllZeros(int number) {
        for (int i = 100; i < number; i *= 10) {
            if (number % i != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int number) {
        String[] str = Integer.toString(number).split("");
        StringBuilder partStart = new StringBuilder();
        StringBuilder partEnd = new StringBuilder();

        for (int i = 0; i < str.length / 2; i++) {
            partStart.append(str[i]);
            partEnd.append(str[str.length - i - 1]);
        }

        return partStart.toString().equals(partEnd.toString());
    }

    private static boolean isSequential(int number, boolean isRevers) {
        int n = number % 10;
        number /= 10;
        do {
            int diff = 0;

            if (!isRevers) {
                diff = n - number % 10;
            } else {
                diff = number % 10 - n;
            }

            if (diff != 1) {
                return false;
            }

            n = number % 10;
            number /= 10;
        } while (number > 0);
        return true;

    }

    private static int checkAwesomePhrase(int number, int[] awesomePhrases) {
        for (int i : awesomePhrases) {
            int diff = i - number;
            if (diff == 2 || diff == 1) {
                return 1;
            } else if(diff == 0) {
                return 2;
            }
        }
        return 0;
    }

    private static boolean numberIdenticalDigits(int number) {
        int n = number % 10;
        do {
            if (n != number % 10) {
                return false;
            }
            number /= 10;
        } while (number > 0);
        return true;
    }

    public static void main(String[] args) {
       // System.out.println(CarMileage.isInteresting(1221, new int[]{}));
        System.out.println(CarMileage.isInteresting(10000, new int[]{}));
//
//        System.out.println(CarMileage.isInteresting(254, new int[]{1337, 256})); // 1
//        System.out.println(CarMileage.isInteresting(255, new int[]{1337, 256})); // 1
//        System.out.println(CarMileage.isInteresting(256, new int[]{1337, 256})); // 2
    }


}
