package com.lala.example.spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Standard {

    // https://www.spoj.com/TEAMX_01/status/
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        while (true) {
            int myInt = scanner.nextInt();
            if (myInt == 42) {
                break;
            }
            System.out.println(myInt);
        }*/
//        List<Integer> n_List = new ArrayList<>();
//            n_List.add(myInt);
        List<Integer> primes = generateBasePrimes((int) Math.sqrt(1000000000) + 1);
        for (Integer prime : primes) {
            System.out.println(prime);
        }
    }

    public void standardReadAndPrint() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        System.out.println(count);
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
