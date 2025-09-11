package com.lala.example.spoj.dynamicProgramming;

import java.io.*;
import java.util.*;

public class PhilosophersStone {
    public static void main(String[] args) throws IOException {
        // read file input
        File file = new File("src/main/java/com/lala/example/spoj/dynamicProgramming/input.txt");
        Scanner sc = new Scanner(file);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] stones = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                stones[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // DP
        int[][] dp = new int[h][w];
        for (int j = 0; j < w; j++) {
            dp[0][j] = stones[0][j];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int bestPrev = dp[i - 1][j];
                if (j > 0) bestPrev = Math.max(bestPrev, dp[i - 1][j - 1]);
                if (j < w - 1) bestPrev = Math.max(bestPrev, dp[i - 1][j + 1]);
                dp[i][j] = stones[i][j] + bestPrev;
            }
        }

        int result = 0;
        for (int j = 0; j < w; j++) {
            result = Math.max(result, dp[h - 1][j]);
        }

        System.out.println("Max stones: " + result);
    }
}
