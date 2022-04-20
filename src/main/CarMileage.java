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
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CarMileage {
    public static int isInteresting(int number, int[] awesomePhrases) {

        System.out.println("number = " + number);
        System.out.println("awesomePhrases = " + Arrays.toString(awesomePhrases));

        if (number < 98) {
            return 0;
        }

        if (number >= 100 && checkNumber(number, awesomePhrases)) {
            return 2;
        } else if (checkNumber(number + 1, awesomePhrases) || checkNumber(number + 2, awesomePhrases)) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean checkNumber(int number, int[] awesomePhrases) {
        String[] test = {"allZero", "isPalindrome", "isSequentialDecrementing", "isSequentialIncrementing", "numberIdenticalDigits", "checkAwesomePhrase"};
        boolean accept = false;

        for (String str :
                test) {
            switch (str) {
                case "allZero" :
                    accept = isAllZeros(number);
                    System.out.println("allZero");
                    break;
                case "isPalindrome":
                    accept = isPalindrome(number);
                    System.out.println("isPalindrome");
                    break;
                case "isSequentialDecrementing":
                    accept = isSequential(number, true);
                    System.out.println("isSequentialDecrementing");
                    break;
                case "isSequentialIncrementing":
                    accept = isSequential(number, false);
                    System.out.println("isSequentialIncrementing");
                    break;
                case "numberIdenticalDigits":
                    accept = numberIdenticalDigits(number);
                    System.out.println("numberIdenticalDigits");
                    break;
                case "checkAwesomePhrase":
                    accept = checkAwesomePhrase(number, awesomePhrases);
                    System.out.println("checkAwesomePhrase");
                    break;
            }
            if (accept) {
                break;
            }
        }
        return accept;
    }

    private static boolean isAllZeros(int number) {
//        for (int i = 100; i < number; i *= 10) {
//            if (number % i != 0) {
//                return false;
//            }
//        }
//        return true;

        return Stream.<Predicate<String>>of(
          s -> s.matches("\\d0+")
        ).anyMatch(p -> number > 99 && p.test(Integer.toString(number)));
    }

    private static boolean isPalindrome(int number) {
//        String[] str = Integer.toString(number).split("");
//        StringBuilder partStart = new StringBuilder();
//        StringBuilder partEnd = new StringBuilder();
//
//        for (int i = 0; i < str.length / 2; i++) {
//            partStart.append(str[i]);
//            partEnd.append(str[str.length - i - 1]);
//        }
//
//        return partStart.toString().equals(partEnd.toString());

        return Stream.<Predicate<String>>of(
                s -> new StringBuilder(s)
                        .reverse()
                        .toString()
                        .equals(s))
                .anyMatch( p -> number > 99 && p.test(Integer.toString(number)));
    }

    private static boolean isSequential(int number, boolean isRevers) {
//        int n = number % 10;
//        number /= 10;
//        do {
//            int diff = 0;
//
//            if (!isRevers) {
//                diff = n - number % 10;
//            } else {
//                diff = number % 10 - n;
//            }
//            if (!isRevers) {
//                if (diff != 1 && n != 0) {
//                    return false;
//                }
//            } else {
//                if (diff != 1) {
//                    return false;
//                }
//            }
//            n = number % 10;
//            number /= 10;
//        } while (number > 0);
//        return true;

//        char[] num = Integer.toString(number).toCharArray();
//
//        for (int i = 0; i < num.length - 1; i++) {
//            if (!isRevers) {
//                int i1 = num[i + 1] - num[i];
//                if (i1 != 1 && i1 != -9) {
//                    return false;
//                }
//            } else {
//                if ((num[i] - num[i + 1]) != 1) {
//                    return false;
//                }
//            }
//
//        }
//        return true;

        if (!isRevers) {
            return Stream.<Predicate<String>>of(
                    "1234567890"::contains
            )
                    .anyMatch(p -> number > 99 && p.test(Integer.toString(number)));
        } else {
            return Stream.<Predicate<String>>of(
                    "9876543210"::contains
            )
                    .anyMatch(p -> number > 99 && p.test(Integer.toString(number)));
        }

    }

    private static boolean checkAwesomePhrase(int number, int[] awesomePhrases) {
//        for (int i : awesomePhrases) {
//            if (i - number == 0) {
//                return true;
//            }
//        }
//        return false;

        return Arrays.stream(awesomePhrases).anyMatch(n -> number == n);

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

        System.out.println(CarMileage.isInteresting(11111, new int[]{1335, 246}));

    }


}
