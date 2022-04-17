package main;

/*
Define a function that takes one integer argument and returns logical value true or false depending on if the integer is a prime.

Per Wikipedia, a prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.

Example
is_prime(1)   false
is_prime(2)   true
is_prime(-1)  false
 */

public class Prime {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.abs(Math.sqrt(num)); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Prime.isPrime(4));
        System.out.println(Prime.isPrime(6));
        System.out.println(Prime.isPrime(8));
        System.out.println(Prime.isPrime(9));
        System.out.println(Prime.isPrime(45));
        System.out.println(Prime.isPrime(-5));
        System.out.println(Prime.isPrime(-8));
        System.out.println(Prime.isPrime(-41));
    }
}
