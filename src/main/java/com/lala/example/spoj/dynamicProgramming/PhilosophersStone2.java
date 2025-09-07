package com.lala.example.spoj.dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * https://www.spoj.com/TEAMX_01/problems/BYTESM2/
 * dp[i][j] = dp[i-1][j] + max(dp[i][j - 1], dp[i][j], dp[i][j + 1])
 */
public class PhilosophersStone2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/lala/example/spoj/dynamicProgramming/testcase.txt"));
        StringBuilder result = new StringBuilder();
        int n_testcase = Integer.parseInt(reader.readLine());
//        System.out.println(n_testcase);
        for (int t = 0; t < n_testcase; t++) {
            String size = reader.readLine();
            String[] s1 = size.split(" ");
            int h = Integer.parseInt(s1[0]);
            int w = Integer.parseInt(s1[1]);
//            System.out.println(h + " " + w);
            int[][] arr = new int[h][w];
            int index = 0;
            int maxRow0 = 0;
            for (int r = 0; r < h; r++) {
                String[] s = reader.readLine().split(" ");
                for (int c = 0; c < w; c++) {
//                    System.out.println(r + " " + c);
                    if (r == 0 && maxRow0 < Integer.parseInt(s[c])) {
                        index = c;
                        maxRow0 = Integer.parseInt(s[c]);
                    }
                    arr[r][c] = Integer.parseInt(s[c]);
                }
            }
            System.out.println(index + " " + maxRow0);
            int sum = maxRow0;
            for (int r = 1; r < h; r++) {
                if (index - 1 < 0) {
                    index = arr[r][index] > arr[r][index + 1] ? index : index + 1;
                } else if (index + 1 > w) {
                    index = arr[r][index - 1] > arr[r][index] ? index - 1 : index;
                } else {
                    index = (arr[r][index - 1] >= arr[r][index] && arr[r][index - 1] >= arr[r][index + 1]) ? index - 1 :
                            (arr[r][index] >= arr[r][index - 1] && arr[r][index] >= arr[r][index + 1]) ? index : index + 1;
                }
                System.out.println(r + " " + index);
                sum += arr[r][index];
            }
            result.append(sum);
            if (t < n_testcase) {
                result.append("\n");
            }
        }
        System.out.println(result);
    }
}
