package com.lala.example.spoj.a_warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author thehatredman
 * APS - Amazing Prime Sequence
 * a[0] = a[1] = 0
 * For n > 1: a[n] = a[n-1] + f(n)
 * where f(n) is smallest prime factor of n.
 * T <= 100
 * 1 < n < 10.000.000
 * @since 26-Aug-2025
 */
public class AmazingPrimeSequence {

    static int MAX_N = 10_000_000; // 1e7
    static int[] spf = new int[MAX_N + 1]; // smallest prime factor
    static long[] prefixSum = new long[MAX_N + 1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt(); // count number of test case

        // todo find f(n): 2, 3, 5, 7, 11, 13, 17, 19
        sieveSPF(MAX_N);

        // TODO find a[0], a[1], ..., a[n-1], a[n]
        // a[2] = a[2-1] + f(2)
        prefixSum[0] = 0;
        prefixSum[1] = 0;
        for (int i = 2; i <= MAX_N; i++) {
            prefixSum[i] = prefixSum[i - 1] + spf[i];
        }

        for (int i = 0; i < count; i++) {
            int n = scanner.nextInt();
            System.out.println(prefixSum[n]);
        }
    }

    private static void sieveSPF(int n) {
        for (int i = 2; i <= n; i++) {
            if (spf[i] == 0) { // i is prime
                spf[i] = i;
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        if (spf[j] == 0) spf[j] = i;
                    }
                }
            }
        }
    }

    private static void linearSieveSPF(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (spf[i] == 0) {
                spf[i] = i;
                primes.add(i);
            }
            for (int p : primes) {
                long x = 1L * p * i;
                if (x > n) break;
                spf[(int)x] = p;
                if (p == spf[i]) break; // đảm bảo mỗi composite chỉ gán 1 lần bằng smallest prime
            }
        }
    }

    public static void sieve(int n) {
        for (int i = 2; i <= n; i++) {
            if (spf[i] == 0) { // i is prime
                for (int j = i; j <= n; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }
    }
}
