package com.lala.example.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * So nguyen to
 */
public class MyPrimeNumbers {

    List<Boolean> basicPrimes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt(); // count number of test case

        for (int i = 0; i < count; i++) {
            long n_first = scanner.nextLong();
            long n_last = scanner.nextLong();

            for (long j = n_first; j <= n_last; j++) {
                if (isPrime(j)) {
                    System.out.println(j);
                }
            }
            System.out.println(); // print new line
        }
    }

    /**
     * This is fail algorithm, because over execute time
     * Giai thuat nay bi vuot qua gioi han thoi gian, ko su dung can tren la can bac 2 cua b
     */
    public static void isPrimeV0() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            long n_first = scanner.nextLong();
            long n_last = scanner.nextLong();
            for (long j = n_first; j <= n_last; j++) {
                if (j > 1) {
                    if (j == 2 || j == 3) {
                        System.out.println(j);
                        continue;
                    }
                    long n_count = 2;
                    while (n_count <= j) {
                        if (j % n_count == 0) {
                            break;
                        }
                        n_count++;
                    }
                    if (n_count == j) {
                        System.out.println(j);
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * function check prime number
     * @param n
     * @return
     */
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        long sqrtN = (long) Math.sqrt(n);
        for (long i = 3; i <= sqrtN; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
