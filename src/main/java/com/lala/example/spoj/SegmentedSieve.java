package com.lala.example.spoj;

import java.util.*;

/**
 * Algorithm segmented sieve - thuat toan sang phan doan - use copilot
 * Step 0: read what is prime and sqrt(n), Algorithm base segment Eratosthenes.
 * Step 1: segment sieve
 */
public class SegmentedSieve {
    // Tìm tất cả số nguyên tố ≤ sqrt(maxN)

    /**
     * Sang tat ca cac so tu [0, limit], tim ra danh sach so nguyen to base
     *
     * @param limit
     * @return
     */
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

    // Sàng phân đoạn từ m đến n
    public static List<Integer> segmentedSieve(int m, int n, List<Integer> basePrimes) {
        int size = n - m + 1;
        boolean[] isPrime = new boolean[size];
        Arrays.fill(isPrime, true);

        for (int p : basePrimes) {
            int start = Math.max(p * p, ((m + p - 1) / p) * p);
            for (int j = start; j <= n; j += p) {
                isPrime[j - m] = false;
            }
        }

        if (m == 1) isPrime[0] = false;

        List<Integer> primesInRange = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (isPrime[i]) primesInRange.add(i + m);
        }
        return primesInRange;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        List<int[]> testCases = new ArrayList<>();
        int maxN = 0; // max n

        for (int i = 0; i < t; i++) {
            String[] parts = sc.nextLine().split(" ");
            int m = Integer.parseInt(parts[0]);
            int n = Integer.parseInt(parts[1]);
            testCases.add(new int[]{m, n});
            maxN = Math.max(maxN, n);
        }

        // create list base prime <= ((int) sqrt(maxN) + 1)
        // Tạo danh sách số nguyên tố cơ sở ≤ sqrt(maxN)
        List<Integer> basePrimes = generateBasePrimes((int) Math.sqrt(maxN) + 1);

        for (int i = 0; i < t; i++) {
            int m = testCases.get(i)[0];
            int n = testCases.get(i)[1];
            List<Integer> primes = segmentedSieve(m, n, basePrimes);
            for (int p : primes) {
                System.out.println(p);
            }
            if (i < t - 1) System.out.println(); // Dòng trống giữa các test case
        }
    }
}