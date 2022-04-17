package main;

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
