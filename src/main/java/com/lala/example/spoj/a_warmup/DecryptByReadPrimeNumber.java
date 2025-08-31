package com.lala.example.spoj.a_warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DecryptByReadPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] split = next.split("");
        int length = split.length;

        List<Integer> basePrimes = generateBasePrimes((int) Math.sqrt(length) + 1);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            if (basePrimes.contains(i)) {
                out.append(split[i]);
            }
        }
        System.out.println(out);
    }

    public static List<Integer> generateBasePrimes(int limit) {
        // create array from 0 to limit
        boolean[] isPrime = new boolean[limit + 1];
        // fill true to all index mark is primer
        Arrays.fill(isPrime, true);
        // value = 0, 1 is false
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) { // if true is not verify then check
                for (int j = i * i; j <= limit; j += i) {
                    // mark index i * i is false is not prime
                    isPrime[j] = false;
                }
            }
        }

        // if index from array is true is prime
        List<Integer> basePrimes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) basePrimes.add(i);
        }
        return basePrimes;
    }
}
