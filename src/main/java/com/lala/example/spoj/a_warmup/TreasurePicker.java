package com.lala.example.spoj.a_warmup;

/**
 * FSUM - Sum
 */

import java.util.*;

public class TreasurePicker {
    static int n;
    static int[][] a; // array input
    static int[][] dp; // array mask luu ket qua

    public static int solve(int row, int mask) {
        if (row == n) return 0;
        if (dp[row][mask] != -1) return dp[row][mask];

        int maxVal = Integer.MIN_VALUE;
        for (int col = 0; col < n; col++) {
            if ((mask & (1 << col)) == 0) {
                int val = a[row][col] + solve(row + 1, mask | (1 << col));
                maxVal = Math.max(maxVal, val);
            }
        }
        dp[row][mask] = maxVal;
        return maxVal;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//
//        a = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                a[i][j] = scanner.nextInt();
//            }
//        }

//        unit test
        a = new int[][]{
                {10, 2, 3},
                {4, 15, 6},
                {7, 8, 9}
        };

        n = a.length;
        dp = new int[n][1 << n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int result = solve(0, 0);
        System.out.println(result);
    }
}

